package ru.itis.chats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.chats.model.MessageDto;
import ru.itis.chats.serv.MesServImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    @Lazy
    private MesServImpl mesServ;

    @MessageMapping("/{usver}/{room}.sendMessage")
    @SendTo("/topic/public")
    public MessageDto sendMessage(@Payload MessageDto message) {
        System.out.println(message);
        mesServ.putMessage(message);
        return message;
    }

    @MessageMapping("{usver}/{room}.addUser")
    @SendTo("/topic/public")
    public List<MessageDto> addUser(@Payload MessageDto message,
                                    SimpMessageHeaderAccessor headerAccessor) {
        System.out.println(message);
        headerAccessor.getSessionAttributes().put("username", message.getFrom());
        return mesServ.getAllByRoom(message.getRoom());
    }

}
