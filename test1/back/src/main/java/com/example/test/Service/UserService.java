package com.example.test.Service;

import com.example.test.Forms.LoginForm;
import com.example.test.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<String> getAllOnlineUsers();

    Optional<User> getUserByName(String name);

    void putNewOnlineUser(LoginForm loginForm);


    void logout(String name);


}
