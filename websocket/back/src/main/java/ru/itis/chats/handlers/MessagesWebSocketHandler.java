package ru.itis.chats.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.chats.forms.MessageDto;
import ru.itis.chats.serv.MesServImpl;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MessagesWebSocketHandler extends TextWebSocketHandler {


    private static Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    private ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    private MesServImpl mesServ;

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String messageAsString = (String) message.getPayload();
        MessageDto body = objectMapper.readValue(messageAsString, MessageDto.class);
        System.out.println(body.getText());
        if (body.getText().equals("Hello!") && body.getFrom() != null) {
            sessions.put(body.getFrom(), session);
        }
        if (!body.getText().equals("Hello!")) {
            System.out.println(body.getFrom());
            mesServ.putMessage(body);
        }
        for (WebSocketSession currentSession : sessions.values()) {
            currentSession.sendMessage(new TextMessage(messageAsString));
        }
    }
}
