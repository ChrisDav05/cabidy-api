package com.example.cabidy.Dtos.Checklist;

import java.util.UUID;

public class CreateChecklistDTO {

    private UUID vehicleId;

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }
}

