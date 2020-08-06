package com.example.chet.controllers;

import com.example.chet.dto.MessageDto;
import com.example.chet.model.Token;
import com.example.chet.serv.MesServImpl;
import com.example.chet.serv.TokenServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {
    @Autowired
    private TokenServImpl tokenServ;
    @Autowired
    private MesServImpl mesServ;

    @GetMapping("/chat/{usver}")
    public List<MessageDto> getChatPage(@PathVariable("usver") String usver) {
        System.out.println("Chat");
        Token token = tokenServ.findFirstByUsver(usver).get();
        List<MessageDto> list = null;
        if (tokenServ.isNotExpired(token.getValue())) {
            System.out.println(mesServ.getAllMessages().toArray().length + " LENGTH");
            list = mesServ.getAllMessages();
        }
        return   list;
    }
}
