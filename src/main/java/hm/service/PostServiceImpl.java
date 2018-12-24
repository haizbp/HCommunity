package hm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hm.entity.CategoryEntity;
import hm.entity.CategoryPostEntity;
import hm.entity.PostEntity;
import hm.entity.TagEntity;
import hm.entity.TagPostEntity;
import hm.model.CategoryModel;
import hm.model.CategoryPostModel;
import hm.model.PostModel;
import hm.model.TagModel;
import hm.model.TagPostModel;
import hm.repository.CategoryPostRepository;
import hm.repository.PostRepository;
import hm.repository.TagPostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private TagPostRepository tagPostRepository;
	@Autowired
	private CategoryPostRepository categoryPostRepository;

	@Override
	public PostModel save(PostModel model) throws Exception {

		PostModel target;
		boolean isInsert = true;
		if (model.getId() != null && model.getId() > 0) {
			PostEntity entity = postRepository.getOne(model.getId());

			if (entity != null) {
				target = PostModel.from(entity);
				target.setActivity(model.getActivity());
				target.setbColor(model.getbColor());
				target.setContent(model.getContent());
				target.setCreatedDate(model.getCreatedDate());
				target.setDisable(model.getDisable());
				target.setId(model.getId());
				target.setLastModified(model.getLastModified());
				target.setReply(model.getReply());
				target.setTitle(model.getTitle());
				target.setUser(model.getUser());
				target.setView(model.getView());
			} else {
				throw new NullPointerException();
			}

			isInsert = false;
		} else {
			target = model;
		}

		PostEntity entity = PostEntity.from(target);

		if (isInsert) {
			entity.setCreatedDate(entity.getLastModified());
		}

		entity = postRepository.save(entity);

		if (entity == null) {
			model = null;
		} else {
			model = PostModel.from(entity);
			
			TagPostEntity tagPostEntity;
			for (TagModel tagPost : target.getTags()) {
				tagPostEntity = new TagPostEntity();
				tagPostEntity.setPost(entity);
				tagPostEntity.setTag(TagEntity.from(tagPost));
				
				tagPostRepository.save(tagPostEntity);
			}
			model.setTags(target.getTags());
			
			CategoryPostEntity categoryPostEntity;
			for (CategoryModel categoryPostModel : target.getCategories()) {
				categoryPostEntity = new CategoryPostEntity();
				categoryPostEntity.setPost(entity);
				categoryPostEntity.setCategory(CategoryEntity.from(categoryPostModel));
				
				categoryPostRepository.save(categoryPostEntity);
			}
			model.setCategories(target.getCategories());
		}

		return model;
	}
}
