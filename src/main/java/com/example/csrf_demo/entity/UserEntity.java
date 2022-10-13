package com.example.csrf_demo.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class UserEntity {
    @Id
    private long id;
    private String name;
    private String password;
}
