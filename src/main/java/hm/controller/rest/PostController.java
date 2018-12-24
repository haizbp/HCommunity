package hm.controller.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hm.annotation.ApiVersion;
import hm.model.PostModel;
import hm.model.Response;
import hm.service.PostService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/post")
@ApiVersion(1)
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/{page}")
	public Mono<Response> get(@PathVariable("page") int page) {
		Response response = new Response();

		try {
			Object model = postService.get(page);
			response.setData(model);
		} catch (Exception e) {
			response.setData(new ArrayList<>());
			response.setCode(500);
			response.setMessage(e.getMessage());
		}

		return Mono.just(response);
	}
	
	@GetMapping("/search")
	public Mono<Response> get(@RequestParam("page") int page,
			@RequestParam("q") String query) {
		Response response = new Response();

		try {
			Object model = postService.get(query, page);
			response.setData(model);
		} catch (Exception e) {
			response.setData(new ArrayList<>());
			response.setCode(500);
			response.setMessage(e.getMessage());
		}

		return Mono.just(response);
	}

	@PostMapping
	public Mono<Response> insert(@RequestBody PostModel model) {
		Response response = new Response();

		try {
			model = postService.save(model);
			response.setData(model);
		} catch (Exception e) {
			response.setCode(500);
			response.setMessage(e.getMessage());
		}

		return Mono.just(response);
	}

	@PutMapping
	public Mono<Response> update(@RequestBody PostModel model) {
		Response response = new Response();

		try {
			model = postService.save(model);
			response.setData(model);
		} catch (Exception e) {
			response.setCode(500);
			response.setMessage(e.getMessage());
		}

		return Mono.just(response);
	}

}
