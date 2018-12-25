package hm.model;

import hm.entity.UserEntity;

public class UserModel extends AbstractModel {

	private String username;
	private String password;
	private String img;
	private Long posted;
	private Long thread;
	private Long lastActivity;
	private String display;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public static UserModel from(UserEntity entity) {
		UserModel user = new UserModel();

		user.setUsername(entity.getUsername());
		user.setImg(entity.getImg());
		user.setPosted(entity.getPosted());
		user.setThread(entity.getThread());
		user.setLastActivity(entity.getLastActivity());
		user.setDisable(entity.getDisable());
		user.setId(entity.getId());
		user.setDisplay(entity.getDisplay());
		return user;
	}

}
