package ru.itis.chats.rep;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itis.chats.model.Message;

import java.util.List;

@Repository
@Lazy
public interface MesRep  extends CrudRepository<Message,Long> {

    @Query(value = "from Message")
    List<Message> getAll();

    @Query(value = "from Message  where  room=:room")
    List<Message> getAllByRoom(Integer room);
}
