package ru.itis.chats.rep;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itis.chats.model.Message;

import java.util.List;

@Repository
public interface MesRep  extends CrudRepository<Message,Long> {

    @Query(value = "from Message")
    List<Message> getAll();
}
