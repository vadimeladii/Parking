package md.utm.fcim.notification.config.swagger

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider
import springfox.documentation.swagger.web.SwaggerResource
import springfox.documentation.swagger.web.SwaggerResourcesProvider
import java.util.stream.Collectors.toList
import java.util.stream.Stream
import javax.annotation.Resource

@Component
@Primary
class CombinedSwaggerResourcesProvider(@Resource
                                       val inMemorySwaggerResourcesProvider: InMemorySwaggerResourcesProvider) : SwaggerResourcesProvider {

    override fun get(): List<SwaggerResource> {
        val jerseySwaggerResource = SwaggerResource()
        jerseySwaggerResource.location = "/api/swagger.json"
        jerseySwaggerResource.swaggerVersion = "2.0"
        jerseySwaggerResource.name = "Jersey"

        return Stream.concat(Stream.of(jerseySwaggerResource), inMemorySwaggerResourcesProvider.get().stream()).collect(toList())
    }
}
