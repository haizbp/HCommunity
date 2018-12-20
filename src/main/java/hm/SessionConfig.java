package hm;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.ReactiveMapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.config.annotation.web.server.EnableSpringWebSession;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

@Configuration
@EnableRedisWebSession
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {

	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory(); 
	}
	
	@Bean
	@Primary
	public ReactiveMapSessionRepository reactiveSessionRepository() {
		return new ReactiveMapSessionRepository(new ConcurrentHashMap<>());
	}

}