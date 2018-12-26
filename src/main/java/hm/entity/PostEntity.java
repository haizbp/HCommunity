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

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

import hm.model.PostModel;

@Entity
@Table(name = "post")
@Indexed
public class PostEntity extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	@Field(store = Store.YES)
	@Analyzer(definition = "utf8analyzer")
	private String bColor;
	@Column
	@Field(store = Store.YES)
	@Analyzer(definition = "utf8analyzer")
	private Integer activity;
	@Column
	@Field(store = Store.YES)
	@Analyzer(definition = "utf8analyzer")
	private Integer view;
	@Column
	@Field(store = Store.YES)
	@Analyzer(definition = "utf8analyzer")
	private Integer reply;
	@Column
	@Field(store = Store.YES)
	@Analyzer(definition = "utf8analyzer")
	private String title;
	@Column
	@Field(store = Store.YES)
	@Analyzer(definition = "utf8analyzer")
	private String content;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private UserEntity user;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private Set<TagPostEntity> tagPosts = new HashSet<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private Set<CategoryPostEntity> categoryPosts = new HashSet<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private Set<UserPostActivityEntity> userPostActivitys = new HashSet<>();

	public String getbColor() {
		return bColor;
	}

	public void setbColor(String bColor) {
		this.bColor = bColor;
	}

	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Integer getReply() {
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Set<TagPostEntity> getTagPosts() {
		return tagPosts;
	}

	public void setTagPosts(Set<TagPostEntity> tagPosts) {
		this.tagPosts = tagPosts;
	}

	public Set<CategoryPostEntity> getCategoryPosts() {
		return categoryPosts;
	}

	public void setCategoryPosts(Set<CategoryPostEntity> categoryPosts) {
		this.categoryPosts = categoryPosts;
	}

	public Set<UserPostActivityEntity> getUserPostActivitys() {
		return userPostActivitys;
	}

	public void setUserPostActivitys(Set<UserPostActivityEntity> userPostActivitys) {
		this.userPostActivitys = userPostActivitys;
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
