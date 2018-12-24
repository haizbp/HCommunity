package hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hm.entity.TagPostEntity;

@Repository
public interface TagPostRepository extends JpaRepository<TagPostEntity, Long> {

}
