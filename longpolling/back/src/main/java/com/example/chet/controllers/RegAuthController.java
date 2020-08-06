package com.example.chet.controllers;

import com.example.chet.forms.LoginForm;
import com.example.chet.forms.RegForm;
import com.example.chet.serv.UsverServ;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class RegAuthController {
    @Autowired
    @Lazy
    private UsverServ usverServ;

    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @GetMapping("/reg")
//    public String loadReg() {
//        return "reg";
//    }

//    @PostMapping("/reg")
//    public ResponseEntity<Object> reg(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password, @RequestParam(name = "login") String login) {
//        System.out.println(email + " " + password + " " + login);
//        RegForm regForm = RegForm.builder()
//                .email(email)
//                .password(password)
//                .usverName(login)
//                .build();
//        usverServ.register(regForm);
//        return ResponseEntity.ok().build();
//    }

//    @GetMapping("/login")
//    public String loadLog() {
//        System.out.println("kek");
//        return "login";
//    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody String data) throws IOException {
        LoginForm loginForm = objectMapper.readValue(data, LoginForm.class);
        System.out.println(loginForm.getEmail()+" LOGIN  "+loginForm.getPassword());
        usverServ.login(loginForm).getValue();
        return ResponseEntity.ok().build();

    }
}
