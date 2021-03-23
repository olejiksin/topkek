package c.t.catt.repos;

import c.t.catt.models.VoteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteUserRep extends JpaRepository<VoteUser, Integer> {
    Optional<VoteUser> getByEmail(String email);

}
