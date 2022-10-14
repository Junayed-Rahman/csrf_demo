package com.example.csrf_demo.service;

import com.example.csrf_demo.dto.UserRegistrationDto;
import com.example.csrf_demo.entity.UserEntity;
import com.example.csrf_demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;


    public UserEntity saveUser(UserEntity userEntity){
        userEntity = userRepository.save(userEntity);
        return userEntity;
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
