package hm.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hm.annotation.ApiVersion;
import hm.model.CategoryModel;
import hm.model.Response;
import hm.model.TagModel;
import hm.service.CategoryService;
import reactor.core.publisher.Mono;

@RestController("/category")
@ApiVersion(1)
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public Mono<Response> get() {
		Response response = new Response();
		List<CategoryModel> models;
		try {
			models = categoryService.get();
			response.setData(models);
		} catch (Exception e) {
			response.setData(new ArrayList<>());
			response.setCode(500);
			response.setMessage(e.getMessage());
		}

		return Mono.just(response);
	}

	@PostMapping
	public Mono<Response> insert(@RequestBody CategoryModel model) {
		Response response = new Response();

		try {
			model = categoryService.save(model);
			response.setData(model);
		} catch (Exception e) {
			response.setCode(500);
			response.setMessage(e.getMessage());
		}

		return Mono.just(response);
	}

	@PutMapping
	public Mono<Response> update(@RequestBody CategoryModel model) {
		Response response = new Response();

		try {
			model = categoryService.save(model);
			response.setData(model);
		} catch (Exception e) {
			response.setCode(500);
			response.setMessage(e.getMessage());
		}

		return Mono.just(response);
	}

}
