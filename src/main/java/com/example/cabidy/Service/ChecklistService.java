package com.example.cabidy.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    public Checklist create(UUID vehicleId) {
        Vehicle vehicle = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        Checklist checklist = new Checklist();
        checklist.setVehicle(vehicle);
        checklist.setCriadoEm(LocalDateTime.now());
        checklist.setAssinadoCliente(false);
        checklist.setAssinadoTecnico(false);

        return repo.save(checklist);
    }

    public Checklist finish(UUID id) {
        Checklist checklist = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Checklist não encontrado"));

        checklist.setFinalizadoEm(LocalDateTime.now());
        return repo.save(checklist);
    }

    public List<Checklist> list() {
        return repo.findAll();
    }

}
