package hm.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

import hm.model.NotificationModel;

@Entity
@Table(name = "notification")
@Indexed
public class NotificationEntity extends AbstractEntity {

	private String type;
	private String icon;
	private String value;
	private String key;
	private Boolean read;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private UserEntity user;

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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public static NotificationEntity from(NotificationModel model) {
		NotificationEntity entity = new NotificationEntity();

		entity.setCreatedDate(model.getCreatedDate());
		entity.setDisable(model.getDisable());
		entity.setId(model.getId());
		entity.setLastModified(model.getLastModified());
		
		entity.setType(model.getType());
		entity.setIcon(model.getIcon());
		entity.setValue(model.getValue());
		entity.setKey(model.getKey());
		entity.setRead(model.getRead());
		entity.setUser(UserEntity.from(model.getUser()));

		return entity;
	}

}
