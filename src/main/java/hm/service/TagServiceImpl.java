package hm.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import hm.entity.TagEntity;
import hm.model.TagModel;
import hm.repository.TagRepository;

@Service
public class TagServiceImpl implements TagService {

	public static final String TAG_LIST_CACHE_KEY = "TAG_LIST_CACHE_KEY";
	@Autowired
	private TagRepository tagRepository;

	@Override
	@Cacheable(value = "SystemCache", key = "#root.target.TAG_LIST_CACHE_KEY")
	public List<TagModel> get() {
		return tagRepository.findAllByDisableIsFalse().stream().map(t -> TagModel.from(t)).collect(Collectors.toList());
	}

	@Override
	public TagModel save(TagModel model) throws Exception {

		TagModel target;
		boolean isInsert = true;
		if (model.getId() != null && model.getId() > 0) {
			TagEntity tagEntity = tagRepository.getOne(model.getId());

			if (tagEntity != null) {
				target = TagModel.from(tagEntity);
				target.setKey(model.getKey());
				target.setValue(model.getValue());
				target.setColor(model.getColor());
				target.setDisable(model.getDisable());
			} else {
				throw new NullPointerException();
			}

			isInsert = false;
		} else {
			target = model;
		}

		TagEntity entity = TagEntity.from(target);

		if (isInsert) {
			entity.setCreatedDate(entity.getLastModified());
		}

		entity = tagRepository.save(entity);

		if (entity == null) {
			model = null;
		} else {
			model = TagModel.from(entity);
		}

		return model;
	}

}
