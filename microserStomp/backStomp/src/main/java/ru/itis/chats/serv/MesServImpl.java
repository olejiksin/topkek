package ru.itis.chats.serv;

import org.springframework.context.annotation.Lazy;
import ru.itis.chats.rep.MesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.chats.model.MessageDto;
import ru.itis.chats.model.Message;

import java.util.ArrayList;
import java.util.List;

@Service
@Lazy
public class MesServImpl implements MesServ {
    @Autowired
    @Lazy
    private MesRep mesRep;

    @Override
    public List<Message> getAll() {
        return mesRep.getAll();
    }
    @Override
    public List<MessageDto> getAllByRoom(Integer room){
        List<Message> list=mesRep.getAllByRoom(room);
        List<MessageDto> list1=new ArrayList<>();
        for(Message message:list){
            MessageDto messageDto= MessageDto.builder()
                    .from(message.getUsver())
                    .text(message.getMessage())
                    .room(message.getRoom())
                    .type(message.getType())
                    .build();
            list1.add(messageDto);
        }
        return list1;
    }

    @Override
    public void putMessage(MessageDto messageDto){
        System.out.println(messageDto.getFrom());
        Message message=Message.builder()
                .message(messageDto.getText())
                .usver(messageDto.getFrom())
                .room(messageDto.getRoom())
                .type(messageDto.getType())
                .build();
        mesRep.save(message);
    }
}
