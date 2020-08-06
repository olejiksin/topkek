package com.example.chet.serv;

import com.example.chet.model.Token;
import com.example.chet.rep.TokenRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TokenServImpl implements TokenServ {
    @Autowired
    private TokenRep tokenRep;
    @Autowired
    private UsverServImpl usverServ;
    @Override
    public boolean isNotExpired(String token) {
        return LocalDateTime.now().isBefore(tokenRep.findFirstByValue(token).get().getExpiredDateTime());
    }
    @Override
    public Optional<Token> findFirstByUsver(String email){
        return tokenRep.findFirstByUsverId(usverServ.findIdByEmail(email)) ;
    }


}
