package md.utm.fcim.usermanagement.webservice;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/api/user")
public interface UserController {

    @GET
    @Path("/")
    String test();
}
