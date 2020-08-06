package com.example.chet.rep;

import com.example.chet.model.Message;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Lazy
public interface MesRep extends CrudRepository<Message,Long> {
    @Query(nativeQuery = true, value = "select * from messages")
    List<Message>  getAll();
}
