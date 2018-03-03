package md.utm.fcim.notification.jersey

import io.swagger.jaxrs.config.BeanConfig
import io.swagger.jaxrs.listing.ApiListingResource
import io.swagger.jaxrs.listing.SwaggerSerializers
import md.utm.fcim.notification.impl.NotificationControllerImpl
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component
import javax.ws.rs.ApplicationPath

@Component
@ApplicationPath("/api")
class JerseyConfig : ResourceConfig() {

    init {
        registerEndpoints()
        configureSwagger()
    }

    private final fun registerEndpoints() {
        register(NotificationControllerImpl::class.java)
    }

    private fun configureSwagger() {
        // Available at host:port/swagger.json
        this.register(ApiListingResource::class.java)
        this.register(SwaggerSerializers::class.java)

        val config = BeanConfig()
        config.configId = "springboot-jersey-swagger"
        config.title = "Notification"
        config.version = "v1"
        config.contact = "Eladii Vadim"
        config.schemes = arrayOf("http", "https")
        config.resourcePackage = "md.utm.fcim.notification"
        config.prettyPrint = true
        config.basePath = "/api"
//        config.scan = true
    }
}
