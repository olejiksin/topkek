package kurs.services;

import kurs.dto.TokenDto;
import kurs.forms.LoginForm;
import kurs.forms.RegForm;
import kurs.reps.TokenRep;
import kurs.reps.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import kurs.models.Token;
import kurs.models.Usver;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {

    private Integer expiredTime = 3600;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRep userRep;

    @Autowired
    private TokenRep tokenRep;
    @Autowired
    private TokenServ tokenServ;

    @Override
    public String reg(RegForm regForm) {
        if ((userRep.findByEmail(regForm.getEmail()).isPresent() && userRep.findByLogin(regForm.getLogin()) == null)) {
            Usver usver = Usver.builder()
                    .name(regForm.getName())
                    .surname(regForm.getSurname())
                    .hash(passwordEncoder.encode(regForm.getPassword()))
                    .phonenumber(regForm.getPhone())
                    .email(regForm.getEmail())
                    .build();
            userRep.save(usver);
            return "ok";
        } else {
            return "nope";
        }
    }

    @Override
    public TokenDto login(LoginForm loginForm) {
        Usver usver = userRep.findByLogin(loginForm.getLogin());
        if (usver == null) {
            return null;
        } else if (passwordEncoder.matches(loginForm.getPassword(), usver.getHash())) {
            if (tokenServ.findFirstByUser(usver.getEmail()).isPresent()) {
                Token tok = tokenServ.findFirstByUser(usver.getEmail()).get();
                return TokenDto.from(tok.getValue());
            } else {
                String value = UUID.randomUUID().toString();
                Token token = Token.builder()
                        .createdAt(LocalDateTime.now())
                        .expiredDateTime(LocalDateTime.now().plusSeconds(expiredTime))
                        .value(value)
                        .usver(usver)
                        .build();
                System.out.println(LocalDateTime.now() + ":now" + "    not now:" + LocalDateTime.now().plusSeconds(expiredTime));
                tokenRep.save(token);
                return TokenDto.from(value);
            }
        }
        throw new BadCredentialsException("Incorrect login or password");
    }

    @Override
    public Long findIdByEmail(String email) {
        return userRep.findByEmail(email).get().getId();
    }
}
