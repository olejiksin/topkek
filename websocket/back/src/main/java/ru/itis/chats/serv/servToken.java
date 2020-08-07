package ru.itis.chats.serv;

import ru.itis.chats.forms.Token;

import java.util.Optional;

public interface servToken {

    Token get(String val);

    void save(String val);

    boolean isNotExpired(String token);

    Optional<Token> getLast();
}
