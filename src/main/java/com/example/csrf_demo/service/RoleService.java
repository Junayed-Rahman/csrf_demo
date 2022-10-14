package com.example.csrf_demo.service;

import com.example.csrf_demo.entity.RoleEntity;
import com.example.csrf_demo.entity.UserEntity;
import com.example.csrf_demo.enums.UserRoleEnum;
import com.example.csrf_demo.repository.RoleRepository;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;

import static com.example.csrf_demo.enums.UserPermissionEnum.USER_READ;
import static com.example.csrf_demo.enums.UserPermissionEnum.USER_WRITE;
import static com.google.common.collect.Sets.newHashSet;

@Service
@AllArgsConstructor
public class RoleService {
    private RoleRepository roleRepository;


    public UserEntity addRoleToUser(UserEntity user){
        RoleEntity roleEntity = new RoleEntity(UserRoleEnum.USER, user);
        user.setRoles(Sets.newHashSet(roleEntity));
        return user;
    }
}
