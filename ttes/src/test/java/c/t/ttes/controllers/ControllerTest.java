package c.t.ttes.controllers;

import c.t.ttes.dto.PlanetDTO;
import c.t.ttes.dto.RulerDTO;
import c.t.ttes.models.Ruler;
import c.t.ttes.services.PlanetService;
import c.t.ttes.services.RulerService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTest {

    @Autowired
    private PlanetService planetService;
    @Autowired
    private RulerService rulerService;

    @Test
    public void testAddNewRuler() {
        rulerService.addNew(RulerDTO.builder().age(34).name("bubab").build());
        Assert.assertTrue(rulerService.getByName("bubab"));
    }

    @Before
    public void set() {
        planetService.deletePlanet(PlanetDTO.builder().name("bubap").build());
    }

    @Test
    public void testAddNewPlanet() {
        planetService.addNew(PlanetDTO.builder().name("bubap").build());
        Assert.assertNotNull(planetService.getByName("bubap"));
    }

    @Before
    public void setP() {
        planetService.addNew(PlanetDTO.builder().name("gh").build());
    }

    @Test
    public void testSetRuler() {
        planetService.setRuler("gh", 6L);
        Assert.assertSame(6L, planetService.getByName("gh").getRuler().getId());
    }

    @Test
    public void testDeletePlanet() {
        planetService.deletePlanet(PlanetDTO.builder().name("gh").build());
        Assert.assertNull(planetService.getByName("gh"));
    }

    @Test
    public void testGetAllLazyRulers() {
        rulerService.addNew(RulerDTO.builder().age(34).name("bubaka").build());
        List<Ruler> lazy = rulerService.getAllLazy();
        Assert.assertTrue(!lazy.isEmpty());
    }

    @Before
    public void insertTop() {
        rulerService.addNew(RulerDTO.builder().age(35).name("bubaka1").build());
        rulerService.addNew(RulerDTO.builder().age(36).name("bubaka2").build());
        rulerService.addNew(RulerDTO.builder().age(37).name("bubaka3").build());
        rulerService.addNew(RulerDTO.builder().age(38).name("bubaka4").build());
        rulerService.addNew(RulerDTO.builder().age(39).name("bubaka5").build());
        rulerService.addNew(RulerDTO.builder().age(31).name("bubaka6").build());
        rulerService.addNew(RulerDTO.builder().age(32).name("bubaka7").build());
        rulerService.addNew(RulerDTO.builder().age(44).name("ka").build());
        rulerService.addNew(RulerDTO.builder().age(54).name("aka").build());
        rulerService.addNew(RulerDTO.builder().age(64).name("baka").build());
        rulerService.addNew(RulerDTO.builder().age(74).name("ubaka").build());

    }

    @Test
    public void testGetTop() {
        Assert.assertSame(10, rulerService.getTop().size());
    }

}