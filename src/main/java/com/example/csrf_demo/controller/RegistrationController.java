package com.example.csrf_demo.controller;

import com.example.csrf_demo.dto.UserRegistrationDto;
import com.example.csrf_demo.entity.UserEntity;
import com.example.csrf_demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private UserService userService;

    @GetMapping(value = "/register")
    public String registerNewUserAccount(@ModelAttribute UserRegistrationDto userDto){
        userService.encodePassword(userDto);
        UserEntity user = userService.mapDTOToUser(userDto);
        userService.saveUser(user);
        return null;
    }
}
