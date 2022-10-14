package com.example.csrf_demo.entity;

import com.example.csrf_demo.enums.UserRoleEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Collection<UserEntity> users = new HashSet<>();

    public RoleEntity(UserRoleEnum userRoleEnum, UserEntity user) {
        this.id = userRoleEnum.getId();
        this.name = userRoleEnum.name();
        this.users.add(user);
    }
}
