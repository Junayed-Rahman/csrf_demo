package com.example.csrf_demo.controller;

import com.example.csrf_demo.dto.UserLoginRequestDto;
import com.example.csrf_demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    private UserService userService;

    public String userLogin(@ModelAttribute UserLoginRequestDto userDto){


        return null;
    }
}
