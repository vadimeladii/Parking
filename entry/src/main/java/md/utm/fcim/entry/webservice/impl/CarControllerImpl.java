package md.utm.fcim.entry.webservice.impl;

import md.utm.fcim.entry.webservice.CarController;
import org.springframework.stereotype.Component;

@Component
public class CarControllerImpl implements CarController {

    public String test() {
        return "cars";
    }
}
