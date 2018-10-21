package com.alex.zuulexample.userservice.services;

import com.alex.zuulexample.userservice.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
        this.users.add(new User("Tom"));
        this.users.add(new User("Jerry"));
    }

    public List<User> getUsers() {
        return this.users;
    }
}
