package ru.itis.chats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.chats.forms.GetDto;
import ru.itis.chats.model.Message;
import ru.itis.chats.serv.MesServImpl;
import ru.itis.chats.serv.servToken;

import java.util.List;
import java.util.UUID;

@RestController
public class IndexController {

    @Autowired
    private servToken servToken;

    @Autowired
    private MesServImpl mesServ;

    @GetMapping("/room")
    public GetDto getIndexPage() {
        String id = UUID.randomUUID().toString();
//        model.addAttribute("id",id);
//        Cookie cookie=new Cookie("token",id );
//        cookie.setMaxAge(3600);
//        response.addCookie(cookie);
        servToken.save(id);
        System.out.println(mesServ.getAll().size());
        return GetDto.builder().listOfMess(mesServ.getAll())
                .token(id)
                .build();
//        return "index_web_sockets";
    }
}
