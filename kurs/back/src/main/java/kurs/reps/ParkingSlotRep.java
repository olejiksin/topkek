package kurs.reps;

import kurs.models.SlotsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import kurs.models.ParkingSlot;
import reactor.core.publisher.Flux;

import javax.transaction.Transactional;
import java.util.List;

@RepositoryRestResource(path = "slot")
public interface ParkingSlotRep extends JpaRepository<ParkingSlot, Long> {

    @Transactional
    @Query("from ParkingSlot ")
    @RestResource(rel = "getAll", path = "all")
    List<ParkingSlot> getAll();

    @Transactional
    @Query(nativeQuery = true, value = "select * from parking_slot where status='available'")
    @RestResource(rel = "getAllAv", path = "getAvailable")
    List<ParkingSlot> getAllAv();

    @Modifying
    @Query("delete  from ParkingSlot slot where slot.id=:id")
    @Transactional
    @RestResource(rel = "deleteByID", path = "delSlotBId")
    void deleteById(@Param("id") Long id);

    @Transactional
    @Modifying
    @RestResource(rel = "updateSlotStatus", path = "updateStatus")
    @Query("update  ParkingSlot  set  slotsStatus=:slotsStatus where id=:id")
    void updateSlotStatus(SlotsStatus slotsStatus, @Param("id") Long id);

    @Transactional
    @Modifying
    @RestResource(rel = "updateSlotPrice", path = "updatePrice")
    @Query("update  ParkingSlot  set  price_per_hour=:price where id=:id")
    void updateSlotPrice(@Param("id") Long id, @Param("price") Integer price);
}
