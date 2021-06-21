package kurs.controllers;

import kurs.models.Token;
import kurs.reps.TokenRep;
import kurs.services.ParkingSlotService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import kurs.models.ParkingSlot;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class ParkingController {

    @Autowired
    private TokenRep tokenRep;
    @Autowired
    private ParkingSlotService service;
    @Autowired
    AmqpTemplate template;

    @RequestMapping(path = "/tokenn",method = RequestMethod.GET)
    public Token gett() {
        return tokenRep.findFirstByUsverId(1L).get();
    }
    @RequestMapping(path = "/slot/search/updateStatus", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateStatus(@RequestBody ParkingSlot slot) {
        template.convertAndSend("queue", slot);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "/slot/search/updateStatus", method = RequestMethod.GET)
    public ResponseEntity<Object> get() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ParkingSlot> getAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ParkingSlot> getAllAvailable() {
        return service.getAllAv();
    }
}
