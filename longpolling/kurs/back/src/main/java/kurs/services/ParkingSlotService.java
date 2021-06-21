package kurs.services;

import kurs.models.ParkingSlot;
import reactor.core.publisher.Flux;

public interface ParkingSlotService {
    Flux<ParkingSlot> getAll();

    Flux<ParkingSlot> getAllAv();
}
