package com.example.csrf_demo.service;

import com.example.csrf_demo.dto.UserRegistrationDto;
import com.example.csrf_demo.entity.RoleEntity;
import com.example.csrf_demo.entity.UserEntity;
import com.example.csrf_demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;


    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public void encodePassword (UserRegistrationDto userDto){
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
    }

    public UserEntity mapDTOToUser(UserRegistrationDto userDto){
        UserEntity user = modelMapper.map(userDto, UserEntity.class);
        return user;
    }

}
