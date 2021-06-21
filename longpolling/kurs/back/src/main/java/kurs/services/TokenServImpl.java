package kurs.services;


import kurs.reps.TokenRep;
import kurs.reps.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kurs.models.Token;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TokenServImpl implements TokenServ {
    @Autowired
    private TokenRep tokenRep;
    @Autowired
    private UserRep userRep;

    @Override
    public boolean isNotExpired(String token) {
        return LocalDateTime.now().isBefore(tokenRep.findFirstByValue(token).get().getExpiredDateTime());
    }
    @Override
    public Optional<Token> findFirstByUser(String email){
        return tokenRep.findFirstByUsverId(userRep.findByEmail(email).get().getId()) ;
    }


}
