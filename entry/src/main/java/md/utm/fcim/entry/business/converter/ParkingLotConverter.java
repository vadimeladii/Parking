package md.utm.fcim.entry.business.converter;

import com.google.common.base.Converter;
import md.utm.fcim.entry.business.dto.ParkingLot;
import md.utm.fcim.entry.repository.entity.ParkingLotEntity;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotConverter extends Converter<ParkingLot, ParkingLotEntity> {

    @Override
    protected ParkingLotEntity doForward(ParkingLot dto) {
        ParkingLotEntity entity = new ParkingLotEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCounter(dto.getCounter());
        entity.setPlace(dto.getPlace());
        return entity;
    }

    @Override
    protected ParkingLot doBackward(ParkingLotEntity entity) {
        ParkingLot dto = new ParkingLot();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCounter(entity.getCounter());
        dto.setPlace(entity.getPlace());
        return dto;
    }
}
