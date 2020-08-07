package ru.itis.chats.serv;

import ru.itis.chats.forms.MessageDto;
import ru.itis.chats.model.Message;

import java.util.List;

public interface MesServ {
    List<Message> getAll();

    void putMessage(MessageDto messageDto);
}
