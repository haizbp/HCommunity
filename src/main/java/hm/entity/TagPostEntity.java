package hm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

import hm.model.CategoryPostModel;
import hm.model.TagPostModel;

@Table(name = "tagPost")
@Entity
@Indexed
public class TagPostEntity extends AbstractEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private PostEntity post;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private TagEntity tag;

	public PostEntity getPost() {
		return post;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}

	public TagEntity getTag() {
		return tag;
	}

	public void setTag(TagEntity tag) {
		this.tag = tag;
	}

	public static TagPostEntity from(TagPostModel model) {
		TagPostEntity entity = new TagPostEntity();

		entity.setTag(TagEntity.from(model.getTag()));
		entity.setCreatedDate(model.getCreatedDate());
		entity.setDisable(model.getDisable());
		entity.setId(model.getId());
		entity.setLastModified(model.getLastModified());
		entity.setPost(PostEntity.from(model.getPost()));

		return entity;
	}
	
}
