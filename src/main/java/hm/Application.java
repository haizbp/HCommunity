package hm;

import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "${spring.component-scan}")
public class Application {

	public static void main(String[] args) throws MalformedURLException {
		SpringApplication.run(Application.class, args);
	}

}
