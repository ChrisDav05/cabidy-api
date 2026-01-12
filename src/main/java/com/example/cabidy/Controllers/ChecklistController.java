package com.example.cabidy.Controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Checklist criar(@PathVariable UUID vehicleId) {
        return service.criar(vehicleId);
    }

    @PutMapping("/{id}/finalizar")
    public Checklist finalizar(@PathVariable UUID id) {
        return service.finalizar(id);
    }
}

