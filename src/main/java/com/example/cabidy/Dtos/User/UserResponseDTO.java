package com.example.cabidy.Dtos.User;

import java.util.UUID;
import com.example.cabidy.enums.UserRole;

public class UserResponseDTO {

    private UUID id;
    private String nome;
    private String email;
    private UserRole role;

    public UserResponseDTO(UUID id, String nome, String email, UserRole role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }
}
