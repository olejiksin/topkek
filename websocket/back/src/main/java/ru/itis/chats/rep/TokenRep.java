package ru.itis.chats.rep;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itis.chats.forms.Token;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Lazy
public interface TokenRep extends CrudRepository<Token, Long> {
    Optional<Token> findFirstByToken(String value);


    @Query(value = "select * from  token order by id desc  limit 1", nativeQuery = true)
    Optional<Token> findLastToken();

}
