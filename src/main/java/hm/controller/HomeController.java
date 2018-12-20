package hm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.MapSession;
import org.springframework.session.ReactiveMapSessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.WebSession;

import reactor.core.publisher.Mono;

@Controller
public class HomeController {

	@Autowired
	private ReactiveMapSessionRepository reactiveMapSessionRepository;

	@GetMapping("/")
	public Mono<String> home(Model model, WebSession session) {
		session.getAttributes().put("test", "ok");
		return Mono.just("views/home");
	}

}
