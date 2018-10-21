package com.alex.zuulexample.userservice.services;

import com.alex.zuulexample.userservice.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void processSignUp(String userJson);
}
