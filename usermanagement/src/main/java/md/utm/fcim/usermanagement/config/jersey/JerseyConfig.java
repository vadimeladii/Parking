package md.utm.fcim.usermanagement.config.jersey;

import md.utm.fcim.usermanagement.webservice.impl.UserControllerImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(UserControllerImpl.class);
    }

}
