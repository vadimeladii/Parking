package md.utm.fcim.usermanagement.webservice

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api/user/")
interface UserController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun retrieve(): Response

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun retrieveById(@PathParam("id") id: Long): Response
}
