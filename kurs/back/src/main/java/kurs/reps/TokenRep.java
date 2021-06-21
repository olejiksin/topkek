package kurs.reps;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import kurs.models.Token;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TokenRep extends CrudRepository<Token, Long> {
    Optional<Token> findFirstByValue(String value);

    void deleteTokensByExpiredDateTimeBefore(LocalDateTime time);

//    @Query("from Token  t where  t.usver=:id")
    Optional<Token> findFirstByUsverId(Long id);


}
