package com.alex.zuulexample.uiserver.controllers;

import com.alex.zuulexample.uiserver.dto.UserDto;
import com.alex.zuulexample.uiserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getSignUpPage() {
        return "registration/signup";
    }

    @PostMapping
    public String signUp(UserDto userDto) {
        userService.register(userDto);
        return "redirect:/profile";
    }
}
