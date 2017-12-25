package md.utm.fcim.usermanagement.config.jersey

import md.utm.fcim.usermanagement.webservice.impl.UserControllerImpl
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

@Component
class JerseyConfig : ResourceConfig() {
    init {
        registerEndpoints()
    }

    private final fun registerEndpoints() {
        register(UserControllerImpl::class.java)
    }

}
