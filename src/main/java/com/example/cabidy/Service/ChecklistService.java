package com.example.cabidy.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cabidy.Entity.Checklist;
import com.example.cabidy.Entity.Vehicle;
import com.example.cabidy.Repositories.ChecklistRepository;
import com.example.cabidy.Repositories.VehicleRepository;

@Service
public class ChecklistService {

    private final ChecklistRepository repo;
    private final VehicleRepository vehicleRepo;

    public ChecklistService(ChecklistRepository repo, VehicleRepository vehicleRepo) {
        this.repo = repo;
        this.vehicleRepo = vehicleRepo;
    }

    public Checklist criar(UUID vehicleId) {
        Vehicle v = vehicleRepo.findById(vehicleId).orElseThrow();

        Checklist c = new Checklist();
        c.setVehicle(v);
        c.setCriadoEm(LocalDateTime.now());

        return repo.save(c);
    }

    public Checklist finalizar(UUID id) {
        Checklist c = repo.findById(id).orElseThrow();
        c.setFinalizadoEm(LocalDateTime.now());
        return repo.save(c);
    }
}

