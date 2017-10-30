package md.utm.fcim.entry.webservice;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/api/car")
public interface CarController {

    @GET
    @Path("/")
    String test();
}
