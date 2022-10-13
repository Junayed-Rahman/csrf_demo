package com.example.csrf_demo.service;

import com.example.csrf_demo.dto.UserLoginRequestDto;
import com.example.csrf_demo.entity.UserEntity;
import com.example.csrf_demo.repository.UserRepository;
import com.example.csrf_demo.security.MyUserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByName(name);
        if (user.isPresent()) {
            return new MyUserPrincipal(user.get());
        } else {
              throw new UsernameNotFoundException("No user found");
        }
    }
}
