package hm.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;

import hm.annotation.ApiVersion;
import reactor.core.publisher.Mono;

@RestController("/test")
@ApiVersion(1)
public class TestController {

	@GetMapping
	public Mono<String> test(WebSession session){
		session.getAttributes().remove("test");
		session.getAttributes().put("test", "Cache  save here!!");
		return Mono.just("Ok!...");
	}
	
	@GetMapping("/get")
	public Mono<String> get(WebSession session){
		String s = (String) session.getAttributes().get("test");
		return Mono.just(s);
	}
	
	
}
