package com.alex.zuulexample.uiserver.services.impl;

import com.alex.zuulexample.uiserver.dto.UserDto;
import com.alex.zuulexample.uiserver.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void register(UserDto userDto) {
        try {
            String userJson = objectMapper.writeValueAsString(userDto);
            rabbitTemplate.convertAndSend(directExchange.getName(), "signup-queue", userJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }
}
