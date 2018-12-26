package hm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.springframework.stereotype.Indexed;

import hm.model.CategoryModel;
import hm.model.CategoryPostModel;
import hm.model.PostModel;

@Table(name = "categoryPost")
@Entity
@Indexed
public class CategoryPostEntity extends AbstractEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private PostEntity post;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private CategoryEntity category;

	public PostEntity getPost() {
		return post;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	public static CategoryPostEntity from(CategoryPostModel model) {
		CategoryPostEntity entity = new CategoryPostEntity();

		entity.setCategory(CategoryEntity.from(model.getCategory()));
		entity.setCreatedDate(model.getCreatedDate());
		entity.setDisable(model.getDisable());
		entity.setId(model.getId());
		entity.setLastModified(model.getLastModified());
		entity.setPost(PostEntity.from(model.getPost()));

		return entity;
	}

}
