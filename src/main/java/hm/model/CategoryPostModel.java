package hm.model;

import hm.entity.CategoryPostEntity;
import hm.entity.UserEntity;

public class CategoryPostModel extends AbstractModel {

	private PostModel post;
	private CategoryModel category;

	public PostModel getPost() {
		return post;
	}

	public void setPost(PostModel post) {
		this.post = post;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public static CategoryPostModel from(CategoryPostEntity entity) {
		CategoryPostModel model = new CategoryPostModel();

		model.setCategory(CategoryModel.from(entity.getCategory()));
		model.setCreatedDate(entity.getCreatedDate());
		model.setDisable(entity.getDisable());
		model.setId(entity.getId());
		model.setLastModified(entity.getLastModified());
		model.setPost(PostModel.from(entity.getPost()));

		return model;
	}

}
