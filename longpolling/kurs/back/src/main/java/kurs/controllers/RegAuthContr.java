package kurs.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kurs.forms.LoginForm;
import kurs.forms.RegForm;
import kurs.reps.UserRep;
import kurs.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kurs.models.Usver;
import kurs.dto.UserAfterLoginDto;
import kurs.dto.UserDto;

@RestController
public class RegAuthContr {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRep userRep;

    @PostMapping("/register")
    public String reg(@RequestBody String data) throws JsonProcessingException {
        RegForm regForm = objectMapper.readValue(data, RegForm.class);
        return usersService.reg(regForm);
    }

    @PostMapping("/login")
    public UserAfterLoginDto login(@RequestBody String data) throws JsonProcessingException {
        LoginForm loginForm = objectMapper.readValue(data, LoginForm.class);
        return UserAfterLoginDto.builder()
                .login(loginForm.getLogin())
                .token(usersService.login(loginForm).getValue())
                .build();
    }

    @GetMapping("/user/{login}")
    public UserDto userProfilePage(@PathVariable("login") String login) {
        Usver u = userRep.findByLogin(login);
        return UserDto.builder()
                .balance(u.getBalance())
                .email(u.getEmail())
                .name(u.getName())
                .phonenumber(u.getPhonenumber())
                .surname(u.getSurname())
                .build();
    }
}
