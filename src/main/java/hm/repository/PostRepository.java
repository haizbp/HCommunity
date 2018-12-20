package hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hm.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
