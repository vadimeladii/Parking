package md.utm.fcim.entry.webservice.converter;

import com.google.common.base.Converter;
import md.utm.fcim.entry.business.dto.ParkingLot;
import md.utm.fcim.entry.webservice.view.ParkingLotView;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotViewConverter extends Converter<ParkingLotView, ParkingLot> {

    @Override
    protected ParkingLot doForward(ParkingLotView view) {
        ParkingLot dto = new ParkingLot();
        dto.setId(view.getId());
        dto.setName(view.getName());
        dto.setPlace(view.getPlace());
        dto.setCounter(view.getCounter());
        return dto;
    }

    @Override
    protected ParkingLotView doBackward(ParkingLot dto) {
        ParkingLotView view = new ParkingLotView();
        view.setId(dto.getId());
        view.setName(dto.getName());
        view.setCounter(dto.getCounter());
        view.setPlace(dto.getPlace());
        return view;
    }
}
