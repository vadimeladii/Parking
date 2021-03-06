package md.utm.fcim.entry.webservice;

import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/parking")
@Api(value = "PARKING Controller Resource Endpoint")
public interface ParkingLotController {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findOne(@PathParam(value = "id") Long id);

    @GET
    @Path("/increment/")
    Response increment();

    @GET
    @Path("/decrement/")
    Response decrement();

    @GET
    @Path("/counter/")
    Response counter();

    @GET
    @Path("/place/")
    Response place();
}
