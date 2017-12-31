package md.utm.fcim.notification

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/api/notification")
interface NotificationController {

    @GET
    @Path("/")
    fun test(): String
}