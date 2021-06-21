package kurs.services;

import kurs.models.ParkingSlot;
import kurs.reps.ParkingSlotRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {
    @Autowired
    private ParkingSlotRep rep;

    @Override
    public Flux<ParkingSlot> getAll() {
        return Flux.fromIterable(rep.getAll());
    }

    @Override
    public Flux<ParkingSlot> getAllAv() {
        return Flux.fromIterable(rep.getAllAv());
    }
}
