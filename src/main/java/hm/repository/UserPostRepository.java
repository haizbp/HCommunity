package hm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hm.entity.PostEntity;
import hm.entity.UserPostActivityEntity;

@Repository
public interface UserPostRepository extends JpaRepository<UserPostActivityEntity, Long> {

	List<UserPostActivityEntity> findByPost(PostEntity post);
	
}
