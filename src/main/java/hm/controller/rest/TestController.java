package hm.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;

import hm.annotation.ApiVersion;
import reactor.core.publisher.Mono;

@RestController("/test")
@ApiVersion(1)
public class TestController {

	@GetMapping("/status")
	public Mono<String> status(WebSession session){
		return Mono.just("Ok! It's working fine...");
	}
	
	@GetMapping("/addSession")
	public Mono<String> addSession(WebSession session){
		session.getAttributes().put("test", "Cache  save here!!");
		return Mono.just("Ok!...");
	}
	
	@GetMapping("/getSession")
	public Mono<String> getSession(WebSession session){
		String s = (String) session.getAttributes().get("test");
		return Mono.just(s);
	}
	
	@GetMapping("/removeSession")
	public Mono<String> removeSession(WebSession session){
		String s = (String) session.getAttributes().remove("test");
		return Mono.just(s);
	}
	
	
}
