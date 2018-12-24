package hm.service;

import java.util.List;

import hm.model.TagModel;

public interface TagService {

	TagModel save(TagModel model) throws Exception;

	List<TagModel> get();

}
