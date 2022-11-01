package com.example.csrf_demo.service;

import com.example.csrf_demo.entity.RoleEntity;
import com.example.csrf_demo.entity.UserEntity;
import com.example.csrf_demo.enums.UserRoleEnum;
import com.example.csrf_demo.repository.RoleRepository;
import com.example.csrf_demo.utils.SetUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private RoleRepository roleRepository;


    public UserEntity addRoleToUser(UserEntity user){
        RoleEntity roleEntity = new RoleEntity(UserRoleEnum.USER, user);
        user.setRoles(SetUtils.newHashSet(roleEntity));
        return user;
    }
}
