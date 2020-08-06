package com.example.chet.rep;

import com.example.chet.model.Usver;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Lazy
@Repository
public interface UsverRep extends CrudRepository<Usver, Long> {
    Optional<Usver> findByEmail(String email);


    Optional<Usver> findFirstByEmail(String email);
}
