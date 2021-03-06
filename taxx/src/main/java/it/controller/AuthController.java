package it.controller;

import it.form.LoginForm;
import it.form.RegDriverForm;
import it.services.DriverService;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


@Controller
public class AuthController {
    @Lazy
    @Autowired
    LoginForm loginForm;
    @Autowired
    @Lazy
    RegDriverForm regDriverForm;

    @Autowired
    @Lazy
    private DriverService driverService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLog(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        loginForm = LoginForm.builder()
                .email(email)
                .password(password)
                .build();
        System.out.println(email + " " + password);
        String cookieValue = driverService.login(loginForm);
        if (cookieValue != null) {
            request.getSession().setAttribute("driverEmail", email);
            Cookie auth = new Cookie("auth", cookieValue);
            response.addCookie(auth);
            return "redirect:/profile";
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String log(HttpServletRequest request, Model model) {
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", "error");
        }
        return "login";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String regDr(Model model) {
        return "reg";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String getRegForm(Model model, @RequestParam(name = "firstname") String firstName, @RequestParam(name = "lastname") String lastName,
                             @RequestParam(name = "email") String email, @RequestParam(name = "phone") String phone, @RequestParam(name = "password") String password,
                             @RequestParam(name = "haveCar") String haveCar) {
        regDriverForm = RegDriverForm.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .haveCar(haveCar)
                .phoneNumber(phone)
                .password(password)
                .build();
//        if (driverService.checkReg(regDriverForm.getEmail())) {
//            model.addAttribute("msg", "Такой email уже используется.");
//            return "reg";
//        }
        driverService.register(regDriverForm);
        return "redirect:/login";
    }
}
