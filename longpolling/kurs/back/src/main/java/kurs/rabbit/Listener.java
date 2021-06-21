package kurs.rabbit;

import kurs.models.ParkingSlot;
import kurs.reps.ParkingSlotRep;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Listener {

    @Autowired
    private ParkingSlotRep rep;

    @RabbitListener(queues = "queue")
    public void firstListener(ParkingSlot slot) {
        System.out.println("2 listener received data: " + slot.getSlotsStatus());
        rep.updateSlotStatus(slot.getSlotsStatus(), slot.getId());
    }
    @RabbitListener(queues = "queue")
    public void secondListener(ParkingSlot slot) {
        System.out.println("1 listener received data: " + slot.getSlotsStatus());
        rep.updateSlotStatus(slot.getSlotsStatus(), slot.getId());
    }
}
