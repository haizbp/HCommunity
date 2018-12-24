package hm.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hm.model.TagModel;

@Table(name = "tag")
@Entity
public class TagEntity extends AbstractEntity {

	private String key;
	private String value;
	private String color;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
	private Set<TagPostEntity> tagPosts = new HashSet<>();

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static TagEntity from(TagModel model) {
		TagEntity tag = new TagEntity();

		tag.setColor(model.getColor());
		tag.setCreatedDate(model.getCreatedDate());
		tag.setDisable(model.getDisable());
		tag.setId(model.getId());
		tag.setKey(model.getKey());
		tag.setLastModified(model.getLastModified());
		tag.setValue(model.getValue());

		return tag;
	}
}
