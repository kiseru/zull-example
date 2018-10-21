package com.alex.zuulexample.catservice.services.impl;

import com.alex.zuulexample.catservice.dto.CatDto;
import com.alex.zuulexample.catservice.services.CatService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    @RabbitListener(queues = "cat-queue")
    public void processFindImageForUser(String userId) {
        CatDto[] cats = restTemplate
                .getForEntity("https://api.thecatapi.com/v1/images/search", CatDto[].class)
                .getBody();
        CatDto catDto = Arrays.stream(cats)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        rabbitTemplate.convertAndSend("zuul-example", "cat-reply-queue", catDto);
    }
}
