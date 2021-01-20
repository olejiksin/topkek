package com.example.test.Controller;

import com.example.test.DTO.ChatDto;
import com.example.test.DTO.MessageDto;
import com.example.test.Model.Message;
import com.example.test.Model.User;
import com.example.test.Service.MessageServiceImpl;
import com.example.test.Service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {
    @Autowired
    private MessageServiceImpl messageService;
    @Autowired
    private UserServiceImpl userService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/chat")
    public ChatDto loadChatPage() {
        return ChatDto.builder()
                .messageDtoList(messageService.getAllMessages())
                .onlineUserList(userService.getAllOnlineUsers())
                .build();
    }

    @PostMapping("/chat/{user}")
    public ResponseEntity<Object> putMessage(@RequestBody String data) throws JsonProcessingException {
        MessageDto messageDto = objectMapper.readValue(data, MessageDto.class);
        messageService.putNewMessage(messageDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/chat/{user}")
    public ResponseEntity<Object> logout(@PathVariable("user") String data) throws JsonProcessingException {
        userService.logout(data);
        return ResponseEntity.ok().build();
    }
}
