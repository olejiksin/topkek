package com.example.chet.serv;

import com.example.chet.dto.MessageDto;
import com.example.chet.model.Message;
import com.example.chet.rep.MesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MesServImpl implements MesServ {
    @Autowired
    @Lazy
    private MesRep mesRep;

    @Override
    public List<MessageDto> getAllMessages() {
        List<MessageDto> list=new ArrayList<>();
        for(Message message:mesRep.getAll()){
            MessageDto messageDto= MessageDto.builder()
                    .text(message.getMessage())
                    .usver(message.getUsver().getUsvername())
                    .build();
            list.add(messageDto);
        }
        return list;
    }


}
