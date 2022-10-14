package com.example.csrf_demo.enums;

import com.google.common.collect.Sets;
import javafx.application.Application;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.csrf_demo.enums.UserPermissionEnum.*;

@AllArgsConstructor
@Getter
public enum UserRoleEnum {
    USER(1, Sets.newHashSet(USER_READ, USER_WRITE)),
    ADMIN(2, Sets.newHashSet(ADMIN_READ, ADMIN_WRITE));

    private final long id;
    private final HashSet<UserPermissionEnum> permissions;

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(userPermissionEnum -> new SimpleGrantedAuthority(userPermissionEnum.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE" + this.name()));
        return  permissions;
    
    }
}
