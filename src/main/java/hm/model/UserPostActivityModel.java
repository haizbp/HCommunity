package hm.model;

import hm.entity.TagEntity;
import hm.entity.UserPostActivityEntity;

public class UserPostActivityModel extends AbstractModel {

	private PostModel post;
	private UserModel user;

	public PostModel getPost() {
		return post;
	}

	public void setPost(PostModel post) {
		this.post = post;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public static UserPostActivityModel from(UserPostActivityEntity entity) {
		UserPostActivityModel model = new UserPostActivityModel();

		model.setUser(UserModel.from(entity.getUser()));
		model.setCreatedDate(model.getCreatedDate());
		model.setDisable(model.getDisable());
		model.setId(model.getId());
		model.setLastModified(model.getLastModified());
		model.setPost(PostModel.from(entity.getPost()));

		return model;
	}

}
