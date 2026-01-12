package com.example.cabidy.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cabidy.Dtos.User.CreateUserDto;
import com.example.cabidy.Entity.User;
import com.example.cabidy.Repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User create(CreateUserDto dto) {
        User user = new User();
        user.setNome(dto.getName());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getPassword());
        return repo.save(user);
    }

    public User findById(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<User> list() {
        return repo.findAll();
    }

    public User update(UUID id, CreateUserDto dto) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setNome(dto.getName());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getPassword());

        return repo.save(user);
    }

    public void delete(UUID id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        repo.deleteById(id);
    }
}
