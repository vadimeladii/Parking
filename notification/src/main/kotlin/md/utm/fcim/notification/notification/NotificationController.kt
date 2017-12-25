package md.utm.fcim.notification.notification

import org.springframework.stereotype.Component
import javax.ws.rs.GET
import javax.ws.rs.Path

@Component
@Path("/api/notification")
interface NotificationController {

    @GET
    @Path("/")
    fun test(): String
}