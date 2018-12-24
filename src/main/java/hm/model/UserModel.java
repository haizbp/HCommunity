package hm.model;

import hm.entity.UserEntity;

public class UserModel extends AbstractModel {

	private String username;
	private String password;
	private String img;
	private String posted;
	private String thread;
	private String lastActivity;

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
	
	public static UserModel from(UserEntity entity) {
		UserModel user = new UserModel();
		
		user.setUsername(entity.getUsername());
		user.setImg(entity.getImg());
		user.setPosted(entity.getPosted());
		user.setThread(user.getThread());
		user.setLastActivity(entity.getLastActivity());
		user.setDisable(entity.getDisable());
		user.setId(entity.getId());
		
		return user;
	}

}
