package com.example.chet.serv;

import com.example.chet.dto.TokenDto;
import com.example.chet.forms.LoginForm;
import com.example.chet.forms.RegForm;
import com.example.chet.model.Message;
import com.example.chet.model.Role;
import com.example.chet.model.Token;
import com.example.chet.model.Usver;
import com.example.chet.rep.MesRep;
import com.example.chet.rep.TokenRep;
import com.example.chet.rep.UsverRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Lazy
@Service
public class UsverServImpl implements UsverServ {

    @Lazy
    @Autowired
    private UsverRep usverRep;


    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenRep tokenRep;
    @Autowired
    private MesRep mesRep;

    @Autowired
    private TokenServImpl tokenServ;
    private Integer expiredTime = 3600;

    @Override
    public Long findIdByEmail(String email) {
        return usverRep.findByEmail(email).get().getId();
    }

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<Usver> userCandidate = usverRep.findFirstByEmail(loginForm.getEmail());
        if (userCandidate.isPresent()) {
            Usver user = userCandidate.get();
            if (passwordEncoder.matches(loginForm.getPassword(), user.getHash())) {
                if (tokenServ.findFirstByUsver(user.getEmail()).isPresent()) {
                    Token tok = tokenServ.findFirstByUsver(user.getEmail()).get();
                    return TokenDto.from(tok.getValue());
                } else {
                    String value = UUID.randomUUID().toString();
                    Token token = Token.builder()
                            .createdAt(LocalDateTime.now())
                            .expiredDateTime(LocalDateTime.now().plusSeconds(expiredTime))
                            .value(value)
                            .usver(user)
                            .build();
                    System.out.println(LocalDateTime.now() + ":now" + "    not now:" + LocalDateTime.now().plusSeconds(expiredTime));
                    tokenRep.save(token);
                    return TokenDto.from(value);
                }
            }
        }
        throw new BadCredentialsException("Incorrect login or password");
    }


    @Override
    public void register(RegForm regForm) {
        Usver usver = Usver.builder()
                .usvername(regForm.getUsverName())
                .email(regForm.getEmail())
                .hash(passwordEncoder.encode(regForm.getPassword()))
                .role(Role.USER)
                .build();
        usverRep.save(usver);
    }

    @Override
    public void putMessage(Long usverId, String message) {
        Message mes = Message.builder()
                .message(message)
                .usver(usverRep.findById(usverId).get())
                .build();
        mesRep.save(mes);
//        usverRep.putMessage(usverId, message, LocalDateTime.now());
    }


}
