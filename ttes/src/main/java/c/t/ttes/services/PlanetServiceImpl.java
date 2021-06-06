package c.t.ttes.services;

import c.t.ttes.dto.PlanetDTO;
import c.t.ttes.models.Planet;
import c.t.ttes.repositories.PlanetRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRep planetRep;

    @Override
    public boolean addNew(PlanetDTO planetDTO) {
        try {
            planetRep.save(Planet.builder()
                    .name(planetDTO.getName())
                    .build());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deletePlanet(PlanetDTO planetDTO) {
        Optional<Planet> planet = planetRep.findByName(planetDTO.getName());
        if (planet.isPresent()) {
            planetRep.delete(planet.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean setRuler(String planetName, Long rulerId) {
        Optional<Planet> planet = planetRep.findByName(planetName);
        if (planet.isPresent()) {
            planetRep.setRuler(rulerId,planetName);
            return true;
        }
        return false;
    }

    @Override
    public Planet getByName(String planetName){
        Optional<Planet> planet=planetRep.findByName(planetName);
        if(planet.isPresent()){
            return planet.get();
        }
        return null;
    }
}
