package com.example.cabidy.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabidy.Dtos.Checklist.ChecklistResponseDTO;
import com.example.cabidy.Entity.Checklist;
import com.example.cabidy.Service.ChecklistService;

@RestController
@RequestMapping("/checklists")
public class ChecklistController {

    private final ChecklistService service;

    public ChecklistController(ChecklistService service) {
        this.service = service;
    }

    @PostMapping("/vehicle/{vehicleId}")
    public Checklist create(@PathVariable UUID vehicleId) {
        return service.create(vehicleId);
    }

    @PatchMapping("/{id}/finish")
    public Checklist finish(@PathVariable UUID id) {
        return service.finish(id);
    }

    @GetMapping
    public List<ChecklistResponseDTO> list() {
        return service.list()
                .stream()
                .map(ChecklistResponseDTO::fromEntity)
                .toList();
    }

}
