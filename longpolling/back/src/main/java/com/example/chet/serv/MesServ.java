package com.example.chet.serv;

import com.example.chet.dto.MessageDto;

import java.util.List;

public interface MesServ {
    List<MessageDto> getAllMessages();
}
