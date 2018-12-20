package hm.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {

	@Column
	private String userame;
	@Column
	private String password;
	@Column
	private String img;
	@Column
	private String posted;
	@Column
	private String thread;
	@Column
	private String lastActivity;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<PostEntity> posts = new HashSet<>();

	public String getUserame() {
		return userame;
	}

	public void setUserame(String userame) {
		this.userame = userame;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPosted() {
		return posted;
	}

	public void setPosted(String posted) {
		this.posted = posted;
	}

	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getLastActivity() {
		return lastActivity;
	}

	public void setLastActivity(String lastActivity) {
		this.lastActivity = lastActivity;
	}

	public Set<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(Set<PostEntity> posts) {
		this.posts = posts;
	}

}
