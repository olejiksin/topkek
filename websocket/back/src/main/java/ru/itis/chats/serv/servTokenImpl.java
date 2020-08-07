package ru.itis.chats.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.itis.chats.forms.Token;
import ru.itis.chats.rep.TokenRep;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Lazy
public class servTokenImpl implements servToken {
    @Autowired
    @Lazy
    private TokenRep tokenRep;

    @Override
    public Token get(String val) {
        return tokenRep.findFirstByToken(val).get();
    }
    @Override
    public void save(String val){
        Token token=Token.builder()
                .token(val)
                .created(LocalDateTime.now())
                .expired(LocalDateTime.now().plusHours(1))
                .build();
        tokenRep.save(token);
    }

    @Override
    public boolean isNotExpired(String token) {
        System.out.println(tokenRep.findFirstByToken(token).get().getExpired());
        return LocalDateTime.now().isBefore(tokenRep.findFirstByToken(token).get().getExpired());
    }

    @Override
    public Optional<Token> getLast(){
        return tokenRep.findLastToken();
    }
}
