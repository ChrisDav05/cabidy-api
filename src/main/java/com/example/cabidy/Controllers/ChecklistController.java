package com.example.cabidy.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.example.cabidy.Dtos.Checklist.ChecklistResponseDTO;
import com.example.cabidy.Dtos.Checklist.CreateChecklistDTO;
import com.example.cabidy.Entity.Checklist;
import com.example.cabidy.Service.ChecklistService;

@RestController
@RequestMapping("/checklists")
public class ChecklistController {

    private final ChecklistService service;

    public ChecklistController(ChecklistService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ChecklistResponseDTO create(@RequestBody CreateChecklistDTO dto) {
        Checklist checklist = service.create(dto.getVehicleId());
        return ChecklistResponseDTO.fromEntity(checklist);
    }

    // FINISH
    @PatchMapping("/{id}/finish")
    public ChecklistResponseDTO finish(@PathVariable UUID id) {
        Checklist checklist = service.finish(id);
        return ChecklistResponseDTO.fromEntity(checklist);
    }

    // LIST
    @GetMapping
    public List<ChecklistResponseDTO> list() {
        return service.list()
            .stream()
            .map(ChecklistResponseDTO::fromEntity)
            .toList();
    }
}
