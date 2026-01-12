package com.example.cabidy.Dtos.VehicleDto;

import java.util.UUID;
import com.example.cabidy.enums.VehicleStatus;

public class VehicleResponseDTO {

    private UUID id;
    private String modelo;
    private String placa;
    private String chassi;
    private String cliente;
    private VehicleStatus status;

    public VehicleResponseDTO(UUID id, String modelo, String placa, String chassi, String cliente,
            VehicleStatus status) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;
        this.cliente = cliente;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getChassi() {
        return chassi;
    }

    public String getCliente() {
        return cliente;
    }

    public VehicleStatus getStatus() {
        return status;
    }
}
