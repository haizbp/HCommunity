package hm.model;

import java.util.List;
import java.util.Set;

import hm.entity.PostEntity;

public class PostModel extends AbstractModel {

	private String bColor;
	private String activity;
	private String view;
	private String reply;
	private String title;
	private String content;
	private UserModel user;
	private List<TagModel> tags;
	private List<CategoryModel> categories;

	public String getbColor() {
		return bColor;
	}

	public void setbColor(String bColor) {
		this.bColor = bColor;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	

	public List<TagModel> getTags() {
		return tags;
	}

	public void setTags(List<TagModel> tags) {
		this.tags = tags;
	}

	public List<CategoryModel> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}

	public static PostModel from(PostEntity entity) {
		PostModel model = new PostModel();

		model.setActivity(entity.getActivity());
		model.setbColor(entity.getbColor());
		model.setContent(entity.getContent());
		model.setCreatedDate(entity.getCreatedDate());
		model.setDisable(entity.getDisable());
		model.setId(entity.getId());
		model.setLastModified(entity.getLastModified());
		model.setReply(entity.getReply());
		model.setTitle(entity.getTitle());
		model.setUser(UserModel.from(entity.getUser()));
		model.setView(entity.getView());

		return model;
	}

}
