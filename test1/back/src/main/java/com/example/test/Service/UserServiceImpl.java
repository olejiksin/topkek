package com.example.test.Service;

import com.example.test.Forms.LoginForm;
import com.example.test.Model.User;
import com.example.test.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<String> getAllOnlineUsers() {
        return userRepository.getAll();
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override

    public void putNewOnlineUser(LoginForm loginForm) {
        User user = User.builder().name(loginForm.getName())
                .online("true")
                .build();
        if (!userRepository.findByName(user.getName()).isPresent()) {
            userRepository.save(user);
        }
        boolean on = false;
        List<String> list = userRepository.getAll();
        for (String s : list) {
            if (s.equals(loginForm.getName())) {
                on = true;
            }
        }
        if (!on) userRepository.plusToOnline(user.getName());

    }


    @Transactional
    @Override
    public void logout(String name) {
        userRepository.deleteUserByName(name);
    }

}
