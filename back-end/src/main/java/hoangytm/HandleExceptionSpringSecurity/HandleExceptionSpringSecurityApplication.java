package hoangytm.HandleExceptionSpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication

public class HandleExceptionSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandleExceptionSpringSecurityApplication.class, args);
	}

}
