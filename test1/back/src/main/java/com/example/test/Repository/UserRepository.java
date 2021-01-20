package com.example.test.Repository;

import com.example.test.Model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query( "select name from User where online='true'")
    List<String> getAll();

    @Modifying
    @Transactional
    @Query("update User set online='false' where name=:name")
    void deleteUserByName(@Param("name") String name);

    Optional<User> findByName(String name);

    @Modifying
    @Transactional
    @Query("update User set online='true' where name=:name")
    void plusToOnline(@Param("name") String name);

}
