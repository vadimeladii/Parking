package md.utm.fcim.usermanagement.webservice

import md.utm.fcim.usermanagement.webservice.view.UserView
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api/user/")
interface UserController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun retrieve(): Response

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun retrieveById(@PathParam("id") id: Long): Response

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun create(userView: UserView): Response
}
