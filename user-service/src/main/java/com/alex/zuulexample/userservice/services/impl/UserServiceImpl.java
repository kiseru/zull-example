package com.alex.zuulexample.userservice.services.impl;

import com.alex.zuulexample.userservice.dto.UserDto;
import com.alex.zuulexample.userservice.models.User;
import com.alex.zuulexample.userservice.repositories.UserRepository;
import com.alex.zuulexample.userservice.services.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @RabbitListener(queues = "signup-queue")
    public void processSignUp(String userJson) {
        try {
            UserDto userDto = objectMapper.readValue(userJson, UserDto.class);
            User user = userDto.getUser();
            userRepository.save(user);
            rabbitTemplate.convertAndSend("zuul-example", "cat-queue", user.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
