package com.example.chet.serv;

import com.example.chet.dto.TokenDto;
import com.example.chet.forms.LoginForm;
import com.example.chet.forms.RegForm;

public interface UsverServ {

    Long findIdByEmail(String email);

    TokenDto login(LoginForm loginForm);

//    String getDICHbyCOOK(HttpServletRequest request);

    void register(RegForm regForm);

    void putMessage(Long usverId, String message);

}
