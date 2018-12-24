package hm.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hm.model.CategoryModel;

@Table(name = "category")
@Entity
public class CategoryEntity extends AbstractEntity {

	private String key;
	private String value;
	private String color;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private Set<CategoryPostEntity> categoryPosts = new HashSet<>();

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

	public static CategoryEntity from(CategoryModel model) {
		CategoryEntity tag = new CategoryEntity();

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
