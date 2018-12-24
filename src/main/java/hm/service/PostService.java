package hm.service;

import hm.model.PostModel;

public interface PostService {

	PostModel save(PostModel model) throws Exception;

	Object get(int page);

	Object get(String search, int page);

}
