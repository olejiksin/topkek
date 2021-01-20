package com.example.test.Repository;

import com.example.test.Model.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long> {
    @Query(nativeQuery = true, value = "select * from test")
    List<Message> getAll();
}
