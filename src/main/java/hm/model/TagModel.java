package hm.model;

import hm.entity.TagEntity;

public class TagModel extends AbstractModel {

	private String key;
	private String value;
	private String color;

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
	
	public static TagModel from(TagEntity entity) {
		TagModel tag = new TagModel();
		
		tag.setColor(entity.getColor());
		tag.setCreatedDate(entity.getCreatedDate());
		tag.setDisable(entity.getDisable());
		tag.setId(entity.getId());
		tag.setKey(entity.getKey());
		tag.setLastModified(entity.getLastModified());
		tag.setValue(entity.getValue());
		
		return tag;
	}

}
