package md.utm.fcim.entry.business.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ParkingLot {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer place;

    @NotNull
    private Integer counter;
}
