package hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hm.entity.NotificationEntity;
import hm.entity.UserEntity;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

}
