package hm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Mono;

@Controller
public class HomeController {

	@GetMapping
	public Mono<String> home(Model model){
		model.addAttribute("msg", "Ok!....");
		return Mono.just("views/home");
	}
	
}
