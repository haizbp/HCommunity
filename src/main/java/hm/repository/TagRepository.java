package hm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hm.entity.TagEntity;
import hm.entity.UserEntity;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {

	List<TagEntity> findAllByDisableIsFalse();
	
}
