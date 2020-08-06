package ru.itis.chats.serv;

import ru.itis.chats.model.MessageDto;
import ru.itis.chats.model.Message;

import java.util.List;

public interface MesServ {
    List<Message> getAll();

    List<MessageDto> getAllByRoom(Integer room);

    void putMessage(MessageDto messageDto);
}
