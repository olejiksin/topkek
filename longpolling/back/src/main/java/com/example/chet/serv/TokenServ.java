package com.example.chet.serv;

import com.example.chet.model.Token;

import java.util.Optional;

public interface TokenServ {
    boolean isNotExpired(String token);

    Optional<Token> findFirstByUsver(String email);

}
