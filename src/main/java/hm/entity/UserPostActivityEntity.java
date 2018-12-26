package hm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.springframework.stereotype.Indexed;

import hm.model.UserPostActivityModel;

@Table(name = "userPostActivity")
@Entity
@Indexed
public class UserPostActivityEntity extends AbstractEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private PostEntity post;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private UserEntity user;

	public PostEntity getPost() {
		return post;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public static UserPostActivityEntity from(UserPostActivityModel model) {
		UserPostActivityEntity entity = new UserPostActivityEntity();

		entity.setUser(UserEntity.from(model.getUser()));
		entity.setCreatedDate(model.getCreatedDate());
		entity.setDisable(model.getDisable());
		entity.setId(model.getId());
		entity.setLastModified(model.getLastModified());
		entity.setPost(PostEntity.from(model.getPost()));

		return entity;
	}

}
