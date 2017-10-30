package md.utm.fcim.entry.webservice.view;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ParkingLotView implements Serializable {

    private Long id;

    private String name;

    private Integer place;

    private Integer counter;
}
