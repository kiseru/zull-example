package com.alex.zuulexample.userservice.dto;

import com.alex.zuulexample.userservice.models.User;
import lombok.Data;

@Data
public class UserDto {

    private String firstName;
    private String lastName;

    public User getUser() {
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
