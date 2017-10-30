package md.utm.fcim.entry.business.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.entry.business.ParkingLotService;
import md.utm.fcim.entry.business.converter.ParkingLotConverter;
import md.utm.fcim.entry.business.dto.ParkingLot;
import md.utm.fcim.entry.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotRepository repository;

    private final ParkingLotConverter converter;

    @Override
    public List<ParkingLot> findAll() {
        return repository.findAll()
                .stream()
                .map(converter.reverse()::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ParkingLot> findOne(Long id) {
        return Optional.ofNullable(repository.findOne(id)).map(converter.reverse()::convert);
    }

    @Override
    public Boolean increment() {
        return true;
    }

    @Override
    public Integer counter() {
        return 10;
    }

    @Override
    public Integer place() {
        return 10;
    }

    @Override
    public Boolean decrement() {
        return true;
    }
}
