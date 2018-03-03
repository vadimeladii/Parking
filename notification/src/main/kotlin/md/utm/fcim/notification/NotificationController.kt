package md.utm.fcim.notification

import io.swagger.annotations.Api
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/notification")
@Api(value = "NORIFICATION Controller Resource Endpoint")
interface NotificationController {

    @GET
    @Path("/")
    fun test(): String
}