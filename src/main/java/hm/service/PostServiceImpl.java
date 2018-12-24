package hm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import hm.Helper;
import hm.entity.CategoryEntity;
import hm.entity.CategoryPostEntity;
import hm.entity.PostEntity;
import hm.entity.TagEntity;
import hm.entity.TagPostEntity;
import hm.model.CategoryModel;
import hm.model.PostModel;
import hm.model.TagModel;
import hm.model.UserModel;
import hm.repository.CategoryPostRepository;
import hm.repository.PostRepository;
import hm.repository.TagPostRepository;
import hm.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	public static final String POST_LIST_CACHE_KEY = "POST_LIST_CACHE_KEY";

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private TagPostRepository tagPostRepository;
	@Autowired
	private CategoryPostRepository categoryPostRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	@Cacheable(value = "SystemCache", key = "#root.target.POST_LIST_CACHE_KEY+':'+#page")
	public Object get(int page) {
		Map<String, Object> response = new HashMap<>();
		Page<PostEntity> pageEntity = postRepository.findAll(PageRequest.of(page - 1, Helper.DEFAULT_PAGE_SIZE));

		fetchData(pageEntity, response);

		return response;
	}
	
	@Override
	@Cacheable(value = "SystemCache", key = "#root.target.POST_LIST_CACHE_KEY+':'+#search+':'+#page")
	public Object get(String search, int page) {
		Map<String, Object> response = new HashMap<>();
		Page<PostEntity> pageEntity = postRepository.findAll(PageRequest.of(page - 1, Helper.DEFAULT_PAGE_SIZE));

		fetchData(pageEntity, response);

		return response;
	}

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

	private void fetchData(Page<PostEntity> page, Map<String, Object> target) {
		target.put("page", page.getNumber() + 1);
		target.put("recordPerPages", Helper.DEFAULT_PAGE_SIZE);
		target.put("totalPages", page.getTotalPages());
		target.put("totalRecords", page.getTotalElements());

		List<PostModel> resContent = new ArrayList<>();
		PostModel tmp;
		List<CategoryPostEntity> categoryEntities;
		List<TagPostEntity> tagEntities;
		for (PostEntity postEntity : page.getContent()) {
			tmp = PostModel.from(postEntity);
			tmp.setUser(UserModel.from(userRepository.getOne(postEntity.getUser().getId())));
			categoryEntities = categoryPostRepository.findByPost(postEntity);
			tagEntities = tagPostRepository.findByPost(postEntity);

			for (CategoryPostEntity e : categoryEntities) {
				tmp.addCategory(CategoryModel.from(e.getCategory()));
			}

			for (TagPostEntity e : tagEntities) {
				tmp.addTag(TagModel.from(e.getTag()));
			}

			resContent.add(tmp);
		}

		target.put("content", resContent);

	}
}
