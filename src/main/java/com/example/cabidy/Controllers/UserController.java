package com.example.cabidy.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabidy.Dtos.User.CreateUserDto;
import com.example.cabidy.Dtos.User.UserResponseDTO;
import com.example.cabidy.Entity.User;
import com.example.cabidy.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserResponseDTO create(@RequestBody CreateUserDto dto) {
        User user = service.create(dto);
        return toResponse(user);
    }

    @GetMapping
    public List<UserResponseDTO> list() {
        return service.list()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public UserResponseDTO findById(@PathVariable UUID id) {
        return toResponse(service.findById(id));
    }

    @PutMapping("/{id}")
    public UserResponseDTO update(
            @PathVariable UUID id,
            @RequestBody CreateUserDto dto
    ) {
        return toResponse(service.update(id, dto));
    }

    private UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getRole()
        );
    }
}
