package com.example.csrf_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CsrfDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsrfDemoApplication.class, args);

    }

}
