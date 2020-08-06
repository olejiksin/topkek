package ru.itis.chats.controller;

import org.springframework.messaging.support.ChannelInterceptorAdapter;
import ru.itis.chats.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;


@Component
public class CustomInter  extends ChannelInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(CustomInter.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("NEW USER, вельком");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            logger.info("User Disconnected, so saaddd : " + username);

            Message message = new Message();
            message.setType(Message.MessageType.LEAVE);
            message.setUsver(username);

            messagingTemplate.convertAndSend("/topic/public", message);
        }
    }
}
