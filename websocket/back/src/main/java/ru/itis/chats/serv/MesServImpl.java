package ru.itis.chats.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.chats.forms.MessageDto;
import ru.itis.chats.model.Message;
import ru.itis.chats.rep.MesRep;

import java.util.List;

@Service
public class MesServImpl implements MesServ {
    @Autowired
    private MesRep mesRep;

    @Override
    public List<Message> getAll() {
        return mesRep.getAll();
    }

    @Override
    public void putMessage(MessageDto messageDto){
        System.out.println(messageDto.getFrom());
        Message message=Message.builder()
                .message(messageDto.getText())
                .usver(messageDto.getFrom())
                .build();
        mesRep.save(message);
    }
}
