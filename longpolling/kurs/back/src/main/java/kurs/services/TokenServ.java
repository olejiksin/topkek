package kurs.services;


import org.springframework.stereotype.Service;
import kurs.models.Token;

import java.util.Optional;

@Service
public interface TokenServ {
    boolean isNotExpired(String token);

    Optional<Token> findFirstByUser(String email);

}
