package kurs.reps;

import kurs.models.Usver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import kurs.models.Roles;

import javax.transaction.Transactional;
import java.util.Optional;

@RepositoryRestResource(path = "usver")
public interface UserRep extends JpaRepository<Usver, Long> {

    Usver findByLogin(String login);

    Optional<Usver> findByEmail(String email);

    @Transactional
    @Modifying
    @RestResource(path = "updateBal", rel = "updateBalance")
    @Query("update Usver set balance=:balance where login=:login")
    void updateBalance(@Param("login") Long login, @Param("balance") Integer balance);

    @Transactional
    @Modifying
    @RestResource(path = "updateRole", rel = "updateRole")
    @Query("update Usver set role=:role where login=:login")
    void updateRole(@Param("login") Long login, @Param("role") Roles role);

}
