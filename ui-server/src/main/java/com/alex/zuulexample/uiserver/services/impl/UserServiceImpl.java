package com.alex.zuulexample.uiserver.services.impl;

import com.alex.zuulexample.uiserver.dto.UserDto;
import com.alex.zuulexample.uiserver.services.UserService;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void register(UserDto userDto) {
        restTemplate.postForEntity("/api/users/users", userDto, userDto.getClass());
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }
}
