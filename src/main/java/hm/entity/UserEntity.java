package hm.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hm.model.UserModel;

@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {

	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String img;
	@Column
	private String posted;
	@Column
	private String thread;
	@Column
	private String lastActivity;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<PostEntity> posts = new HashSet<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<NotificationEntity> notifications = new HashSet<>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<NotificationEntity> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<NotificationEntity> notifications) {
		this.notifications = notifications;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPosted() {
		return posted;
	}

	public void setPosted(String posted) {
		this.posted = posted;
	}

	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getLastActivity() {
		return lastActivity;
	}

	public void setLastActivity(String lastActivity) {
		this.lastActivity = lastActivity;
	}

	public Set<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(Set<PostEntity> posts) {
		this.posts = posts;
	}
	
	public static UserEntity from(UserModel model) {
		UserEntity user = new UserEntity();
		
		user.setUsername(model.getUsername());
		user.setImg(model.getImg());
		user.setPosted(model.getPosted());
		user.setThread(user.getThread());
		user.setLastActivity(model.getLastActivity());
		user.setDisable(model.getDisable());
		user.setId(model.getId());
		
		return user;
	}

}
