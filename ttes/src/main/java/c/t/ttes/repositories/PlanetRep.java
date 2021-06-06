package c.t.ttes.repositories;

import c.t.ttes.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface PlanetRep extends JpaRepository<Planet, Long> {

    Optional<Planet> findByName(String name);

    @Modifying
    @Transactional
    @Query(value = " update Planet  set ruler_id=:rulerId where name=:planetName")
    void setRuler(@Param("rulerId") Long rulerId, @Param("planetName") String planetName);
}
