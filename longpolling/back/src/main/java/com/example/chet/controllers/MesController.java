package com.example.chet.controllers;

import com.example.chet.dto.MessageDto;
import com.example.chet.serv.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MesController {
    private final Map<String, List<MessageDto>> messages = new HashMap<>();


    @Autowired
    private UsverServImpl usverServ;


    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/mes")
    public ResponseEntity<Object> receiveMessage(@RequestBody String data) throws IOException {
        MessageDto message=objectMapper.readValue(data, MessageDto.class);
        if (!messages.containsKey(message.getUsver())) {
            messages.put(message.getUsver(), new ArrayList<>());
        }
        for (List<MessageDto> pageMessages : messages.values()) {
            synchronized (pageMessages) {
                pageMessages.add(message);
                System.out.println(message.getUsver() + "  USVER");
                if (!message.getText().equals("H3LL0, MEGA" + message.getUsver())) {
                    usverServ.putMessage(usverServ.findIdByEmail(message.getUsver()), message.getText());
                    pageMessages.notifyAll();
                }
            }
        }
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @GetMapping("/mes")
    public ResponseEntity<List<MessageDto>> getMessagesForPage(@RequestParam("usver") String usver) {
        System.out.println(usver+" chek");
        synchronized (messages.get(usver)) {
            if (messages.get(usver).isEmpty()) {
                messages.get(usver).wait();
            }
            List<MessageDto> response = new ArrayList<>(messages.get(usver));
            messages.get(usver).clear();
            return ResponseEntity.ok(response);
        }
    }

}
