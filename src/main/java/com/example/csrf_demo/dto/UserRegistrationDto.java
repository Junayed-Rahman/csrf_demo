package com.example.csrf_demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegistrationDto {
    private String name;
    private String password;
    private String email;
}
