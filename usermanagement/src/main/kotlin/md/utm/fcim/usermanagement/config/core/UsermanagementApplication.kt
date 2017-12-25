package md.utm.fcim.usermanagement.config.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
//@EntityScan("md.utm.fcim.usermanagement")
//@EnableJpaRepositories("md.utm.fcim.usermanagement")
@ComponentScan(value = ["md.utm.fcim.usermanagement"])
class UsermanagementApplication

fun main(args: Array<String>) {
    SpringApplication.run(UsermanagementApplication::class.java, *args)
}
