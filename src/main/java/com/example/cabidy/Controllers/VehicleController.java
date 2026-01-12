package com.example.cabidy.Controllers;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabidy.Dtos.VehicleDto.VehicleCreateDTO;
import com.example.cabidy.Dtos.VehicleDto.VehicleResponseDTO;
import com.example.cabidy.Entity.Vehicle;
import com.example.cabidy.Service.VehicleService;
import com.example.cabidy.enums.VehicleStatus;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public VehicleResponseDTO create(@RequestBody VehicleCreateDTO dto) {
        Vehicle v = service.create(dto);
        return toResponse(v);
    }

    @GetMapping
    public List<VehicleResponseDTO> list() {
        return service.list()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public VehicleResponseDTO findById(@PathVariable UUID id) {
        return toResponse(service.findById(id));
    }

    @GetMapping("/placa/{placa}")
    public VehicleResponseDTO findByPlaca(@PathVariable String placa) {
        return toResponse(service.findByPlaca(placa));
    }

    @PatchMapping("/{id}/status")
    public VehicleResponseDTO updateStatus(
            @PathVariable UUID id,
            @RequestParam VehicleStatus status
    ) {
        return toResponse(service.updateStatus(id, status));
    }

    private VehicleResponseDTO toResponse(Vehicle v) {
        return new VehicleResponseDTO(
                v.getId(),
                v.getModelo(),
                v.getPlaca(),
                v.getChassi(),
                v.getCliente(),
                v.getStatus()
        );
    }
}
