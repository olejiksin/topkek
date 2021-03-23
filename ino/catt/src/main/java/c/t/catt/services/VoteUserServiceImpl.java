package c.t.catt.services;

import c.t.catt.models.VoteUser;
import c.t.catt.repos.VoteUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteUserServiceImpl implements VoteUserService {
    @Autowired
    private VoteUserRep rep;

    public boolean checkEmail(String email){
        Optional<VoteUser> user=rep.getByEmail(email);
        if(user.isPresent()){
            return true;
        }else{
            rep.save(VoteUser.builder().email(email).build());
            return false;
        }
    }
}
