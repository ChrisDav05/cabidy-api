package com.example.cabidy.Dtos.Checklist;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.cabidy.Entity.Checklist;

public class ChecklistResponseDTO {

    private UUID id;
    private UUID vehicleId;
    private LocalDateTime criadoEm;
    private LocalDateTime finalizadoEm;
    private boolean assinadoTecnico;
    private boolean assinadoCliente;

    public ChecklistResponseDTO(
            UUID id,
            UUID vehicleId,
            LocalDateTime criadoEm,
            LocalDateTime finalizadoEm,
            boolean assinadoTecnico,
            boolean assinadoCliente) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.criadoEm = criadoEm;
        this.finalizadoEm = finalizadoEm;
        this.assinadoTecnico = assinadoTecnico;
        this.assinadoCliente = assinadoCliente;
    }

    public UUID getId() {
        return id;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getFinalizadoEm() {
        return finalizadoEm;
    }

    public boolean isAssinadoTecnico() {
        return assinadoTecnico;
    }

    public boolean isAssinadoCliente() {
        return assinadoCliente;
    }

    public static ChecklistResponseDTO fromEntity(Checklist checklist) {
        return new ChecklistResponseDTO(
                checklist.getId(),
                checklist.getVehicle().getId(),
                checklist.getCriadoEm(),
                checklist.getFinalizadoEm(),
                checklist.isAssinadoTecnico(),
                checklist.isAssinadoCliente());
    }
}
