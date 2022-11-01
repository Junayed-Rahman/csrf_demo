package com.example.csrf_demo.controller;

import com.example.csrf_demo.dto.UserLoginRequestDto;
import com.example.csrf_demo.dto.UserRegistrationDto;
import com.example.csrf_demo.entity.UserEntity;
import com.example.csrf_demo.security.MyUserPrincipal;
import com.example.csrf_demo.service.RoleService;
import com.example.csrf_demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping(value = "/login")
@Slf4j
@AllArgsConstructor
public class LoginController {

    private UserService userService;
    private RoleService roleService;

    @GetMapping(value = "/form")
    public String showLoginPage(@ModelAttribute UserLoginRequestDto userDto, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("title","User Login Page");

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "public/UserLoginForm";
        }
        else {
            MyUserPrincipal principal = (MyUserPrincipal) authentication.getPrincipal();
            String loggedUserName = ((UserDetails)principal).getUsername();
            model.addAttribute("LoggedUserName", loggedUserName);
            return "public/UserLoginForm";
        }
    }

    @GetMapping("/error")
    @ResponseBody
    public String showFormError(){
        return "Error in form";
    }


//    @PostMapping(value = "/login-process")
//    public String showHomepage(@ModelAttribute UserLoginRequestDto userDto){
//        userService.encodePassword(userDto);
//        UserEntity user = userService.mapDTOToUser(userDto);
//        user = userService.fetchUserByNameAndPassword(userDto);
//        log.info(user.getName() + "is logged in.");
//        System.out.println("Logged in");
//        return "public/UserRegistrationForm";
//    }
}
