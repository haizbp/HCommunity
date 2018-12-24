package hm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hm.entity.NotificationEntity;
import hm.entity.TagEntity;
import hm.entity.UserEntity;
import hm.model.NotificationModel;
import hm.model.TagModel;
import hm.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	public NotificationModel save(NotificationModel model) throws Exception {

		NotificationModel target;
		boolean isInsert = true;
		if (model.getId() != null && model.getId() > 0) {
			NotificationEntity notificationEntity = notificationRepository.getOne(model.getId());

			if (notificationEntity != null) {
				target = NotificationModel.from(notificationEntity);
				target.setKey(model.getKey());
				target.setValue(model.getValue());
				target.setDisable(model.getDisable());
				target.setIcon(model.getIcon());
				target.setRead(model.getRead());
				target.setType(model.getType());
				target.setUser(model.getUser());
			} else {
				throw new NullPointerException();
			}

			isInsert = false;
		} else {
			target = model;
		}

		NotificationEntity entity = NotificationEntity.from(target);

		if (isInsert) {
			entity.setCreatedDate(entity.getLastModified());
		}

		entity = notificationRepository.save(entity);

		if (entity == null) {
			model = null;
		} else {
			model = NotificationModel.from(entity);
		}

		return model;
	}
	
}
