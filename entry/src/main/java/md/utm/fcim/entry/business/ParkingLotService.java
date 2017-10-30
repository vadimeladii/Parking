package md.utm.fcim.entry.business;

import md.utm.fcim.entry.business.dto.ParkingLot;

import java.util.List;
import java.util.Optional;

public interface ParkingLotService {

    List<ParkingLot> findAll();

    Optional<ParkingLot> findOne(Long id);

    Boolean increment();

    Integer counter();

    Integer place();

    Boolean decrement();
}
