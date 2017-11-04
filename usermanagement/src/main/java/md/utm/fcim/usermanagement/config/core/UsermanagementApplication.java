package md.utm.fcim.usermanagement.config.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("md.utm.fcim.usermanagement")
//@EnableJpaRepositories("md.utm.fcim.usermanagement")
@ComponentScan(value = "md.utm.fcim.usermanagement")
public class UsermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);
	}
}
