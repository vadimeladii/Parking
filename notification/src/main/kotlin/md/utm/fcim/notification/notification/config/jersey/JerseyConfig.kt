package md.utm.fcim.notification.notification.config.jersey

import md.utm.fcim.notification.notification.NotificationControllerImpl
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

@Component
class JerseyConfig : ResourceConfig() {

    init {
        registerEndpoints()
    }

    private final fun registerEndpoints() {
        register(NotificationControllerImpl::class.java)
    }
}
