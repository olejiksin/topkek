package c.t.catt.repos;

import c.t.catt.models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatRep extends JpaRepository<Cat,Integer> {

    @Query(value = "from Cat ")
    List<Cat> getAll();
    Optional<Cat> getById(Long id);

    List<Cat> getAllByOrderByVotesDesc();
}
