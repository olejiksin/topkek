package c.t.catt.controller;

import c.t.catt.dto.CattDTO;
import c.t.catt.dto.VoteDTO;
import c.t.catt.dto.VoteUserDTO;
import c.t.catt.services.CatServiceImpl;
import c.t.catt.services.VoteUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private VoteUserServiceImpl voteUserService;
    @Autowired
    private CatServiceImpl catService;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public List<CattDTO> sendCats() {
        return catService.getAll();
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public boolean checkEmail(@RequestBody VoteUserDTO voteUserDTO) {
        return voteUserService.checkEmail(voteUserDTO.getEmail());
    }

    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public void vote(@RequestBody VoteDTO vote) {
        catService.upVote(vote.getCatId());
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public List<CattDTO> getTop() {
            return catService.getTop();
    }
}