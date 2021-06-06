package c.t.ttes.repositories;

import c.t.ttes.models.Ruler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RulerRep extends JpaRepository<Ruler, Long> {

    @Query(value = " select * from rulers r except select ruler.id, age, ruler.name from rulers ruler join planets p on ruler.id = p.ruler_id;", nativeQuery = true)
    List<Ruler> getAllLazy();

    @Query(value = "select * from rulers ruler order by ruler.age limit 10;", nativeQuery = true)
    List<Ruler> getTopTen();

    Optional<Ruler> getByName(String name);
}
