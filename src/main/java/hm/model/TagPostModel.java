package hm.model;

import hm.entity.TagPostEntity;

public class TagPostModel extends AbstractModel {

	private PostModel post;
	private TagModel tag;

	public PostModel getPost() {
		return post;
	}

	public void setPost(PostModel post) {
		this.post = post;
	}

	public TagModel getTag() {
		return tag;
	}

	public void setTag(TagModel tag) {
		this.tag = tag;
	}
	
	public static TagPostModel from(TagPostEntity entity) {
		TagPostModel model = new TagPostModel();

		model.setTag(TagModel.from(entity.getTag()));
		model.setCreatedDate(entity.getCreatedDate());
		model.setDisable(entity.getDisable());
		model.setId(entity.getId());
		model.setLastModified(entity.getLastModified());
		model.setPost(PostModel.from(entity.getPost()));

		return model;
	}

}
