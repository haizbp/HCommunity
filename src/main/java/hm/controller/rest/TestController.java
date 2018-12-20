package hm.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hm.annotation.ApiVersion;
import reactor.core.publisher.Mono;

@RestController("/test")
@ApiVersion(1)
public class TestController {

	@GetMapping
	public Mono<String> test(){
		return Mono.just("Ok!...");
	}
	
	
}
