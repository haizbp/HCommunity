package hm.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hm.entity.NotificationEntity;
import hm.entity.TagEntity;
import hm.entity.UserEntity;

public class NotificationModel extends AbstractModel {

	private String type;
	private String icon;
	private String value;
	private String key;
	private Boolean read;
	private UserModel user;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public static NotificationModel from(NotificationEntity entity) {
		NotificationModel model = new NotificationModel();

		model.setCreatedDate(entity.getCreatedDate());
		model.setDisable(entity.getDisable());
		model.setId(entity.getId());
		model.setLastModified(entity.getLastModified());

		model.setType(entity.getType());
		model.setIcon(entity.getIcon());
		model.setValue(entity.getValue());
		model.setKey(entity.getKey());
		model.setRead(entity.getRead());
		model.setUser(UserModel.from(entity.getUser()));

		return model;
	}

}
