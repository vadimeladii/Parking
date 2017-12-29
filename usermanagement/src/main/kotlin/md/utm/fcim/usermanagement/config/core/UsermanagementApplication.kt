package md.utm.fcim.usermanagement.config.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(value = ["md.utm.fcim.usermanagement"])
@EnableJpaRepositories(value = ["md.utm.fcim.usermanagement"])
@ComponentScan(value = ["md.utm.fcim.usermanagement"])
class UsermanagementApplication

fun main(args: Array<String>) {
    SpringApplication.run(UsermanagementApplication::class.java, *args)
}
