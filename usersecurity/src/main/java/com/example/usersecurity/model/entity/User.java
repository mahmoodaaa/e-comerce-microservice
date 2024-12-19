package com.example.usersecurity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String username;

    private String password;

    private String email;

    private Set<String> roles; // , ROLE_USER, ROLE_ADMIN
}
