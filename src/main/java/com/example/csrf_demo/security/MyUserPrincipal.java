package com.example.csrf_demo.security;

import com.example.csrf_demo.entity.RoleEntity;
import com.example.csrf_demo.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

import static com.example.csrf_demo.enums.UserRoleEnum.ADMIN;
import static com.example.csrf_demo.enums.UserRoleEnum.USER;

@AllArgsConstructor
public class MyUserPrincipal implements UserDetails {

    private UserEntity userEntity;
    private final long userRoleId = 1;
    private final long adminRoleId = 2;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<RoleEntity> roles = userEntity.getRoles();
        Collection<SimpleGrantedAuthority> authorityList = new HashSet<>();

        for (RoleEntity role: roles) {
            if(role.getId() == userRoleId){
                authorityList.addAll(USER.getGrantedAuthority());
            }
            else if(role.getId() == adminRoleId){
                authorityList.addAll(ADMIN.getGrantedAuthority());
            }
        }
        return authorityList;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
