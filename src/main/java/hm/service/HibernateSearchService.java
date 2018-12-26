package hm.service;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.lucene.search.Query;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hm.Helper;

@Service
public class HibernateSearchService {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional
	public <T> Map<String, Object> fuzzySearch(String searchTerm, int page, Class<T> t, String... fields) {

		Map<String, Object> target = new HashMap<>();

		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(t).get();
		Query luceneQuery = qb.keyword().onFields(fields).matching(searchTerm.trim()).createQuery();

		FullTextQuery jpaQuery = (FullTextQuery) fullTextEntityManager.createFullTextQuery(luceneQuery, t);

		long countResult = (long) jpaQuery.getResultSize();
		
		target.put(Helper.TOTAL_PAGES_PREDIX, ((countResult / Helper.DEFAULT_PAGE_SIZE) + 1));
		target.put(Helper.TOTAL_RECORDS_PREDIX, countResult);
		target.put(Helper.PAGE_PREDIX, page);
		target.put(Helper.RECORD_PER_PAGES_PREDIX, Helper.DEFAULT_PAGE_SIZE);
		
		jpaQuery.setFirstResult((page - 1) * Helper.DEFAULT_PAGE_SIZE);
        jpaQuery.setMaxResults(Helper.DEFAULT_PAGE_SIZE);

		target.put(Helper.CONTENT_PREDIX, jpaQuery.getResultList());

		return target;
	}
	
	@Transactional
	public void reIndex() {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		fullTextEntityManager.createIndexer().start();
	}
	
	@Transactional
	public <T> void reIndex(Class<T> t) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		fullTextEntityManager.createIndexer(t).start();
	}

}