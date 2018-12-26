package hm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.WebSession;

import hm.model.PageInfo;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public Mono<String> home(Model model, WebSession session) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setName("Home page");
		model.addAttribute("pageInfo", pageInfo);
		return Mono.just("views/home");
	}
	
	@GetMapping("/create")
	public Mono<String> create(Model model, WebSession session) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setName("Create a new topic");
		model.addAttribute("pageInfo", pageInfo);
		return Mono.just("views/create");
	}

}
