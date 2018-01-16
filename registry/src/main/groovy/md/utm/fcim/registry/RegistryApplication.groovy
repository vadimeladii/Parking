package md.utm.fcim.registry

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
class RegistryApplication {

	static void main(String[] args) {
		SpringApplication.run RegistryApplication, args
	}
}
