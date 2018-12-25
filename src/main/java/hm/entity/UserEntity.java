package hm.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

import hm.model.UserModel;

@Entity
@Table(name = "users")
@Indexed
public class UserEntity extends AbstractEntity {

	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String img;
	@Column
	private Long posted;
	@Column
	private Long thread;
	@Column
	private Long lastActivity;
	private String display;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<PostEntity> posts = new HashSet<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<NotificationEntity> notifications = new HashSet<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserPostActivityEntity> userPostActivitys = new HashSet<>();

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

	public Long getPosted() {
		return posted;
	}

	public void setPosted(Long posted) {
		this.posted = posted;
	}

	public Long getThread() {
		return thread;
	}

	public void setThread(Long thread) {
		this.thread = thread;
	}

	public Long getLastActivity() {
		return lastActivity;
	}

	public void setLastActivity(Long lastActivity) {
		this.lastActivity = lastActivity;
	}

	public Set<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(Set<PostEntity> posts) {
		this.posts = posts;
	}

	public Set<UserPostActivityEntity> getUserPostActivitys() {
		return userPostActivitys;
	}

	public void setUserPostActivitys(Set<UserPostActivityEntity> userPostActivitys) {
		this.userPostActivitys = userPostActivitys;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
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
		user.setDisplay(model.getDisplay());
		return user;
	}

}
