package ru.itis.chats.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeFailureException;
import org.springframework.web.socket.server.HandshakeHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import ru.itis.chats.serv.servToken;

import java.util.Map;

@Component
public class AuthHandshakeHandler implements HandshakeHandler {

    private DefaultHandshakeHandler handshakeHandler = new DefaultHandshakeHandler();

    @Autowired
    private servToken servToken;
    @Override
    public boolean doHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws HandshakeFailureException {
        String co=servToken.getLast().get().getToken();
        if (servToken.isNotExpired(co)) {
            return handshakeHandler.doHandshake(serverHttpRequest, serverHttpResponse, webSocketHandler, map);
        } else {
            serverHttpResponse.setStatusCode(HttpStatus.FORBIDDEN);
            return false;
        }
    }
}
