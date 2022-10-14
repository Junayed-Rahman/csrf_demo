package com.example.csrf_demo.controller;

import com.example.csrf_demo.dto.UserRegistrationDto;
import com.example.csrf_demo.entity.UserEntity;
import com.example.csrf_demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/registration")
public class RegistrationController {

    private UserService userService;

    @GetMapping("/form")
    public String showRegistrationForm(ModelMap modelMap){
        modelMap.addAttribute("title", "User Registration");
        return "public/UserRegistrationForm";
    }


    @PostMapping(value = "/register-process")
    public String registerNewUserAccount(@ModelAttribute UserRegistrationDto userDto){
        userService.encodePassword(userDto);
        UserEntity user = userService.mapDTOToUser(userDto);
        user = userService.saveUser(user);
        log.info(user.toString());
        return "public/UserRegistrationForm";
    }
}
