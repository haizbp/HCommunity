package hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hm.entity.CategoryPostEntity;

@Repository
public interface CategoryPostRepository extends JpaRepository<CategoryPostEntity, Long> {

}
