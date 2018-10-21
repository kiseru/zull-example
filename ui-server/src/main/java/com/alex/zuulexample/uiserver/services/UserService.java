package com.alex.zuulexample.uiserver.services;

import com.alex.zuulexample.uiserver.dto.UserDto;

import java.util.List;

public interface UserService {
    void register(UserDto userDto);
    List<UserDto> getAll();
}
