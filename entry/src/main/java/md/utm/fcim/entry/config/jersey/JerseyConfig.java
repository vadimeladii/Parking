package md.utm.fcim.entry.config.jersey;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import md.utm.fcim.entry.webservice.impl.CarControllerImpl;
import md.utm.fcim.entry.webservice.impl.ParkingLotControllerImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    @PostConstruct
    public void init() {
        // Register components where DI is needed
        this.configureSwagger();
    }

    private void registerEndpoints() {
        register(ParkingLotControllerImpl.class);
        register(CarControllerImpl.class);
    }

    private void configureSwagger() {
        // Available at localhost:port/swagger.json
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setConfigId("springboot-jersey-swagger");
        config.setTitle("Entry");
        config.setVersion("v1");
        config.setContact("Eladii Vadim");
        config.setSchemes(new String[] { "http", "https" });
        config.setResourcePackage("md.utm.fcim.entry");
        config.setPrettyPrint(true);
        config.setBasePath("/api");
        config.setScan(true);
    }

}
