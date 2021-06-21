package kurs.services;

import kurs.dto.TokenDto;
import kurs.forms.RegForm;
import org.springframework.stereotype.Service;
import kurs.forms.LoginForm;

@Service
public interface UsersService {

    String reg(RegForm regForm);
    TokenDto login(LoginForm loginForm);

    Long findIdByEmail(String email);
}
