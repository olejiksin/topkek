package c.t.ttes.controllers;

import c.t.ttes.dto.PlanetDTO;
import c.t.ttes.dto.RulerDTO;
import c.t.ttes.models.Ruler;
import c.t.ttes.services.PlanetService;
import c.t.ttes.services.RulerService;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private RulerService rulerService;
    @Autowired
    private PlanetService planetService;

    @RequestMapping(value = "/newRuler", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewRuler(@RequestBody RulerDTO rulerDTO) {
        boolean res = rulerService.addNew(rulerDTO);
        if (res) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/newPlanet", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewPlanet(@RequestBody PlanetDTO planetDTO) {
        boolean res = planetService.addNew(planetDTO);
        if (res) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/exterminatus", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePlanet(@RequestBody PlanetDTO planetDTO) {
        boolean res = planetService.deletePlanet(planetDTO);
        if (res) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/lazyRulers", method = RequestMethod.GET)
    public List<Ruler> getAllLazyRulers() {
        return rulerService.getAllLazy();
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public List<Ruler> getTop() {
        return rulerService.getTop();
    }

    @RequestMapping(value = "/setRuler/{name}", method = RequestMethod.PUT)
    public ResponseEntity<Object> setRuler(@PathVariable("name") String planetName,@RequestParam("ruler_id") Long rulerId) {
        boolean res=planetService.setRuler(planetName,rulerId);
        if(res)return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
