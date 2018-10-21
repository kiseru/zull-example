package com.alex.zuulexample.uiserver.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("zuul-example");
    }

    @Bean
    public Queue signupQueue() {
        return new Queue("signup-queue");
    }

    @Bean
    public Queue catQueue() {
        return new Queue("cat-queue");
    }

    @Bean
    public Binding emailQueueBinding() {
        return BindingBuilder.bind(signupQueue())
                .to(directExchange())
                .with("email");
    }

    @Bean
    public Binding catQueueBinding() {
        return BindingBuilder.bind(catQueue())
                .to(directExchange())
                .with("cat");
    }
}
