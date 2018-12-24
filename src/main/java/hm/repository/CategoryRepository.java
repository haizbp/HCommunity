package hm.repository;

import java.util.List;

import org.codehaus.groovy.runtime.GroovyCategorySupport.CategoryMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hm.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	List<CategoryEntity> findAllByDisableIsFalse();
	
}
