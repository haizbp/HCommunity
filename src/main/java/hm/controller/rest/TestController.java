package hm.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;

import hm.Helper;
import hm.annotation.ApiVersion;
import hm.model.UserModel;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
@ApiVersion(1)
public class TestController {

	@GetMapping("/status")
	public Mono<String> status(WebSession session) {
		return Mono.just("Ok! It's working fine...");
	}

	@GetMapping("/login")
	public Mono<String> addSession(WebSession session) {
		UserModel model = new UserModel();
		model.setUsername("Haiz");
		model.setImg("");
		model.setPosted(12l);
		model.setThread(12l);
		model.setLastActivity(12l);
		model.setDisable(false);
		model.setId(1212L);

		session.getAttributes().put(Helper.LOGIN_USER_KEY, model);

		return Mono.just("Ok!...");
	}

	@GetMapping("/getSession")
	public Mono<UserModel> getSession(WebSession session) {
		UserModel model = (UserModel) session.getAttributes().get(Helper.LOGIN_USER_KEY);
		return Mono.just(model);
	}

	@GetMapping("/logout")
	public Mono<UserModel> removeSession(WebSession session) {
		UserModel model = (UserModel) session.getAttributes().remove(Helper.LOGIN_USER_KEY);
		return Mono.just(model);
	}

}
