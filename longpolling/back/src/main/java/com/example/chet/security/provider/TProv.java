package com.example.chet.security.provider;


import com.example.chet.security.UserDetailsImpl;
import com.example.chet.security.auth.TokenAuth;
import com.example.chet.serv.TokenServ;
import com.example.chet.serv.TokenServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class TProv implements AuthenticationProvider {


    @Autowired
    @Qualifier(value = "userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenServImpl tokenServ;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        TokenAuth tokenAuthentication = (TokenAuth) auth;

        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(tokenAuthentication.getName());
        if (userDetails != null && tokenServ.isNotExpired(userDetails.getCurrentToken().getValue())) {
            tokenAuthentication.setUserDetails((UserDetailsImpl) userDetails);
            tokenAuthentication.setAuthenticated(true);
        } else {
            throw new BadCredentialsException("Incorrect Token");
        }
        return tokenAuthentication;
    }

    @Override
    public boolean supports(Class<?> auth) {
        return TokenAuth.class.equals(auth);
    }
}
