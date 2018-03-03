package md.utm.fcim.notification.config.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.ComponentScan
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = ["md.utm.fcim.notification"])
//@EnableResourceServer
class NotificationApplication

fun main(args: Array<String>) {
    SpringApplication.run(NotificationApplication::class.java, *args)
}
