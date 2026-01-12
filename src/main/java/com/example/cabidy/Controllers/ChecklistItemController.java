package com.example.cabidy.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabidy.Dtos.ChecklistItem.ChecklistItemResponseDTO;
import com.example.cabidy.Dtos.ChecklistItem.CreateChecklistItemDTO;
import com.example.cabidy.Dtos.ChecklistItem.UpdateChecklistItemDTO;
import com.example.cabidy.Entity.ChecklistItem;
import com.example.cabidy.Service.ChecklistItemService;

@RestController
@RequestMapping("/checklists/{checklistId}/items")
public class ChecklistItemController {

    private final ChecklistItemService service;

    public ChecklistItemController(ChecklistItemService service) {
        this.service = service;
    }

    @PostMapping
    public ChecklistItemResponseDTO create(
            @PathVariable UUID checklistId,
            @RequestBody CreateChecklistItemDTO dto
    ) {
        ChecklistItem item = service.create(checklistId, dto);
        return toResponse(item);
    }

    @GetMapping
    public List<ChecklistItemResponseDTO> list(
            @PathVariable UUID checklistId
    ) {
        return service.listByChecklist(checklistId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @PatchMapping("/{itemId}")
    public ChecklistItemResponseDTO update(
            @PathVariable UUID itemId,
            @RequestBody UpdateChecklistItemDTO dto
    ) {
        return toResponse(service.update(itemId, dto));
    }

    private ChecklistItemResponseDTO toResponse(ChecklistItem item) {
        return new ChecklistItemResponseDTO(
                item.getId(),
                item.getDescricao(),
                item.isConforme(),
                item.getObservacao()
        );
    }
}
