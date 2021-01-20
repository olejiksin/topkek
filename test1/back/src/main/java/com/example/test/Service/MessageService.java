package com.example.test.Service;

import com.example.test.DTO.MessageDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getAllMessages();

    void putNewMessage(MessageDto messageDto);
}
