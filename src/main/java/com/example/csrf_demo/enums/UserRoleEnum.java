package com.example.csrf_demo.enums;

import com.example.csrf_demo.utils.SetUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.csrf_demo.enums.UserPermissionEnum.*;

@AllArgsConstructor
@Getter
public enum UserRoleEnum {
    USER(1, SetUtils.newHashSet(USER_READ, USER_WRITE)),
    ADMIN(2, SetUtils.newHashSet(ADMIN_READ, ADMIN_WRITE));


    private final long id;
    private final Set<UserPermissionEnum> permissions;

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(userPermissionEnum -> new SimpleGrantedAuthority(userPermissionEnum.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return  permissions;
    
    }
}
