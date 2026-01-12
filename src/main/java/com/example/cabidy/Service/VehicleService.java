package com.example.cabidy.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cabidy.Entity.Vehicle;
import com.example.cabidy.Repositories.VehicleRepository;
import com.example.cabidy.Dtos.VehicleDto.VehicleCreateDTO;
import com.example.cabidy.enums.VehicleStatus;

@Service
public class VehicleService {

    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    // 🔹 CREATE usando DTO
    public Vehicle create(VehicleCreateDTO dto) {

        Vehicle vehicle = new Vehicle();
        vehicle.setModelo(dto.getModelo());
        vehicle.setPlaca(dto.getPlaca());
        vehicle.setChassi(dto.getChassi());
        vehicle.setCliente(dto.getCliente());

        vehicle.setStatus(VehicleStatus.EM_INSPECAO);

        return repo.save(vehicle);
    }

    // 🔹 LIST
    public List<Vehicle> list() {
        return repo.findAll();
    }

    // 🔹 UPDATE STATUS
    public Vehicle updateStatus(UUID id, VehicleStatus status) {
        Vehicle vehicle = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        vehicle.setStatus(status);
        return repo.save(vehicle);
    }
}
