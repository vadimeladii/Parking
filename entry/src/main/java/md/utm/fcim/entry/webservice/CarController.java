package md.utm.fcim.entry.webservice;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/car")
@Api(value = "CAR Controller Resource Endpoint")
public interface CarController {

    @GET
    @Path("/")
    String test();
}
