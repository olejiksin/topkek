package c.t.ttes.services;

import c.t.ttes.dto.PlanetDTO;
import c.t.ttes.models.Planet;
import org.springframework.http.ResponseEntity;

public interface PlanetService {
    boolean addNew(PlanetDTO planetDTO);

    boolean deletePlanet(PlanetDTO planetDTO);

    boolean setRuler(String planetName, Long rulerId);

    Planet getByName(String planetName);
}
