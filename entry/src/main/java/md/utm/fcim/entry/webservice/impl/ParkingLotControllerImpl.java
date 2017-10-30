package md.utm.fcim.entry.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.entry.business.ParkingLotService;
import md.utm.fcim.entry.business.dto.ParkingLot;
import md.utm.fcim.entry.webservice.ParkingLotController;
import md.utm.fcim.entry.webservice.converter.ParkingLotViewConverter;
import org.springframework.stereotype.Component;

import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.Status.OK;

import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ParkingLotControllerImpl implements ParkingLotController {

    private final ParkingLotService parkingLotService;

    private final ParkingLotViewConverter converter;

    @Override
    public Response findAll() {
        return Response.ok(parkingLotService.findAll().stream()
                .map(converter.reverse()::convert)
                .collect(Collectors.toList()))
                .build();
    }

    @Override
    public Response findOne(Long id) {
        Optional<ParkingLot> optional = parkingLotService.findOne(id);
        return Response.status(optional.isPresent() ? OK : NO_CONTENT)
                .entity(optional.map(converter.reverse()::convert).orElse(null)).build();
    }

    @Override
    public Response increment() {
        return Response.ok(parkingLotService.increment()).build();
    }

    @Override
    public Response decrement() {
        return Response.ok(parkingLotService.decrement()).build();
    }

    @Override
    public Response counter() {
        return Response.ok(parkingLotService.counter()).build();
    }

    @Override
    public Response place() {
        return Response.ok(parkingLotService.place()).build();
    }
}

