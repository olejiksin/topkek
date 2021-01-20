package com.example.test.Service;

import com.example.test.DTO.MessageDto;
import com.example.test.Model.Message;
import com.example.test.Model.User;
import com.example.test.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<MessageDto> getAllMessages(){
        List<MessageDto> list=new ArrayList<>();
        for(Message message:messageRepository.getAll()){
            MessageDto messageDto=MessageDto.builder()
                    .message(message.getMessage())
                    .user(message.getUser().getName())
                    .build();
            list.add(messageDto);
        }
        return list;
    }
    @Override
    public void putNewMessage(MessageDto messageDto){
        Message message=Message.builder()
                .message(messageDto.getMessage())
                .user(userService.getUserByName(messageDto.getUser()).get())
                .build();
        messageRepository.save(message);
    }
}
