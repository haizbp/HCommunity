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

import hm.model.PostModel;

@Entity
@Table(name = "post")
public class PostEntity extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private String bColor;
	@Column
	private String activity;
	@Column
	private String view;
	@Column
	private String reply;
	@Column
	private String title;
	@Column
	private String content;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private UserEntity user;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private Set<TagPostEntity> tagPosts = new HashSet<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private Set<CategoryPostEntity> categoryPosts = new HashSet<>();

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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public static PostEntity from(PostModel model) {
		PostEntity entity = new PostEntity();

		entity.setActivity(model.getActivity());
		entity.setbColor(model.getbColor());
		entity.setContent(model.getContent());
		entity.setCreatedDate(model.getCreatedDate());
		entity.setDisable(model.getDisable());
		entity.setId(model.getId());
		entity.setLastModified(model.getLastModified());
		entity.setReply(model.getReply());
		entity.setTitle(model.getTitle());
		entity.setUser(UserEntity.from(model.getUser()));
		entity.setView(model.getView());

		return entity;
	}

}
