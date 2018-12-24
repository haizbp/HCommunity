package hm.service;

import java.util.List;

import hm.model.CategoryModel;

public interface CategoryService {

	CategoryModel save(CategoryModel model) throws Exception;

	List<CategoryModel> get();

}
