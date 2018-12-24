package hm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hm.entity.CategoryEntity;
import hm.entity.CategoryPostEntity;
import hm.entity.PostEntity;

@Repository
public interface CategoryPostRepository extends JpaRepository<CategoryPostEntity, Long> {

	List<CategoryPostEntity> findByPost(PostEntity entity);
	
}
