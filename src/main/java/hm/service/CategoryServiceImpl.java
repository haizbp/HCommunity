package hm.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.codehaus.groovy.runtime.GroovyCategorySupport.CategoryMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.session.data.redis.ReactiveRedisOperationsSessionRepository;
import org.springframework.stereotype.Service;

import hm.entity.CategoryEntity;
import hm.entity.TagEntity;
import hm.model.CategoryModel;
import hm.model.TagModel;
import hm.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	public static final String CATEGORY_LIST_CACHE_KEY = "CATEGORY_LIST_CACHE_KEY";
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	@Cacheable(value = "SystemCache", key = "#root.target.CATEGORY_LIST_CACHE_KEY")
	public List<CategoryModel> get() {
		return categoryRepository.findAllByDisableIsFalse().stream().map(t -> CategoryModel.from(t))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryModel save(CategoryModel model) throws Exception {

		CategoryModel target;
		boolean isInsert = true;
		if (model.getId() != null && model.getId() > 0) {
			CategoryEntity categoryEntity = categoryRepository.getOne(model.getId());

			if (categoryEntity != null) {
				target = CategoryModel.from(categoryEntity);
				target.setKey(model.getKey());
				target.setValue(model.getValue());
				target.setColor(model.getColor());
				target.setDisable(model.getDisable());
			} else {
				throw new NullPointerException();
			}

			isInsert = false;
		} else {
			target = model;
		}

		CategoryEntity entity = CategoryEntity.from(target);

		if (isInsert) {
			entity.setCreatedDate(entity.getLastModified());
		}

		entity = categoryRepository.save(entity);

		if (entity == null) {
			model = null;
		} else {
			model = CategoryModel.from(entity);
		}

		return model;
	}

}
