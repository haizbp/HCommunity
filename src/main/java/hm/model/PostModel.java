package hm.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hm.entity.CategoryEntity;
import hm.entity.CategoryPostEntity;
import hm.entity.PostEntity;
import hm.entity.TagPostEntity;

public class PostModel extends AbstractModel {

	private String bColor;
	private Integer activity;
	private Integer view;
	private Integer reply;
	private String title;
	private String content;
	private UserModel user;
	private Set<TagModel> tags;
	private Set<CategoryModel> categories;
	private Set<UserModel> postActivitys;

	public String getbColor() {
		return bColor;
	}

	public void setbColor(String bColor) {
		this.bColor = bColor;
	}

	public Integer getActivity() {
		if (activity == null)
			activity = 0;
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}

	public Integer getView() {
		if (view == null)
			view = 0;
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Integer getReply() {
		if (reply == null)
			reply = 0;
		return reply;
	}

	public void setReply(Integer reply) {
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

	public Set<TagModel> getTags() {
		return tags;
	}

	public void setTags(Set<TagModel> tags) {
		this.tags = tags;
	}

	public Set<CategoryModel> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryModel> categories) {
		this.categories = categories;
	}

	public void addCategory(CategoryModel model) {
		if (categories == null)
			categories = new HashSet<>();
		this.categories.add(model);
	}

	public void addTag(TagModel model) {
		if (tags == null)
			tags = new HashSet<>();
		this.tags.add(model);
	}

	public Set<UserModel> getPostActivitys() {
		return postActivitys;
	}

	public void setPostActivitys(Set<UserModel> postActivitys) {
		this.postActivitys = postActivitys;
	}
	
	public void addPostActivity(UserModel model) {
		if (postActivitys == null)
			postActivitys = new HashSet<>();
		this.postActivitys.add(model);
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
