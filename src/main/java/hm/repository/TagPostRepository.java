package hm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hm.entity.PostEntity;
import hm.entity.TagEntity;
import hm.entity.TagPostEntity;

@Repository
public interface TagPostRepository extends JpaRepository<TagPostEntity, Long> {
	
	List<TagPostEntity> findByPost(PostEntity entity);
	
}
