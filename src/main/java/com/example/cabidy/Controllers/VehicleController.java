package com.example.cabidy.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabidy.Entity.Vehicle;
import com.example.cabidy.Service.VehicleService;
import com.example.cabidy.Dtos.VehicleDto.VehicleCreateDTO;
import com.example.cabidy.enums.VehicleStatus;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    // 🔹 CREATE usando DTO
    @PostMapping
    public ResponseEntity<Vehicle> create(
            @RequestBody VehicleCreateDTO dto) {

        Vehicle vehicle = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }

    // 🔹 LIST
    @GetMapping
    public List<Vehicle> list() {
        return service.list();
    }

    // 🔹 UPDATE STATUS
    @PutMapping("/{id}/status")
    public Vehicle updateStatus(
            @PathVariable UUID id,
            @RequestParam VehicleStatus status) {

        return service.updateStatus(id, status);
    }
}
