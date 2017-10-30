package md.utm.fcim.entry.controller;

import md.utm.fcim.entry.business.ParkingLotService;
import md.utm.fcim.entry.business.dto.ParkingLot;
import md.utm.fcim.entry.config.core.EntryApplication;
import md.utm.fcim.entry.webservice.view.ParkingLotView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {EntryApplication.class})
public class ParkingLotControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ParkingLotService parkingLotService;

    @Test
    public void findAll_shouldResultDefaultResponse() {
        given(this.parkingLotService.findAll())
                .willReturn(getListOfParkingLotWith2Element());
        ResponseEntity<ParkingLotView[]> result = this.restTemplate.getForEntity("/api/parking/", ParkingLotView[].class);
        assertThat(result.getBody().length).isEqualTo(2);
    }

    @Test
    public void findOne_shouldResultStatusCode_NO_CONTENT() {
        given(this.parkingLotService.findOne(1L))
                .willReturn(Optional.empty());
        ResponseEntity<ParkingLotView[]> result = this.restTemplate.getForEntity("/api/parking/1", ParkingLotView[].class);
        assertThat(result.getStatusCode().value()).isEqualTo(NO_CONTENT.getStatusCode());
    }

    @Test
    public void findOne_shouldResultDefaultResponse() {
        ParkingLot parkingLot = getParkingLot();
        given(this.parkingLotService.findOne(1L))
                .willReturn(Optional.ofNullable(parkingLot));
        ResponseEntity<ParkingLotView> result = this.restTemplate.getForEntity("/api/parking/1", ParkingLotView.class);
        assertThat(result.getBody().getId()).isEqualTo(parkingLot.getId());
        assertThat(result.getBody().getName()).isEqualTo(parkingLot.getName());
        assertThat(result.getBody().getPlace()).isEqualTo(parkingLot.getPlace());
        assertThat(result.getBody().getCounter()).isEqualTo(parkingLot.getCounter());
    }

    @Test
    public void increment_shouldResultBody_True() {
        given(this.parkingLotService.increment())
                .willReturn(true);
        ResponseEntity<String> result = this.restTemplate.getForEntity("/api/parking/increment/", String.class);
        assertThat(Boolean.valueOf(result.getBody())).isEqualTo(true);
    }

    @Test
    public void decrement_shouldResultBody_True() {
        given(this.parkingLotService.decrement())
                .willReturn(true);
        ResponseEntity<String> result = this.restTemplate.getForEntity("/api/parking/decrement/", String.class);
        assertThat(Boolean.valueOf(result.getBody())).isEqualTo(true);
    }

    @Test
    public void place_shouldResultBody_30() {
        given(this.parkingLotService.place())
                .willReturn(30);
        ResponseEntity<String> result = this.restTemplate.getForEntity("/api/parking/place/", String.class);
        assertThat(Integer.valueOf(result.getBody())).isEqualTo(30);
    }

    @Test
    public void counter_shouldResultBody_25() {
        given(this.parkingLotService.counter())
                .willReturn(25);
        ResponseEntity<String> result = this.restTemplate.getForEntity("/api/parking/counter/", String.class);
        assertThat(Integer.valueOf(result.getBody())).isEqualTo(25);
    }

    private List<ParkingLot> getListOfParkingLotWith2Element() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(getParkingLot());
        parkingLots.add(getParkingLot());
        return parkingLots;
    }

    private ParkingLot getParkingLot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1L);
        parkingLot.setName("vadim");
        parkingLot.setCounter(20);
        parkingLot.setPlace(30);
        return parkingLot;
    }
}
