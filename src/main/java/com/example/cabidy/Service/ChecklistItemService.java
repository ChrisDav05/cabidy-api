package com.example.cabidy.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cabidy.Dtos.ChecklistItem.CreateChecklistItemDTO;
import com.example.cabidy.Dtos.ChecklistItem.UpdateChecklistItemDTO;
import com.example.cabidy.Entity.Checklist;
import com.example.cabidy.Entity.ChecklistItem;
import com.example.cabidy.Repositories.ChecklistItemRepository;
import com.example.cabidy.Repositories.ChecklistRepository;

@Service
public class ChecklistItemService {

    private final ChecklistItemRepository repo;
    private final ChecklistRepository checklistRepo;

    public ChecklistItemService(
            ChecklistItemRepository repo,
            ChecklistRepository checklistRepo) {
        this.repo = repo;
        this.checklistRepo = checklistRepo;
    }

    public ChecklistItem create(UUID checklistId, CreateChecklistItemDTO dto) {
        Checklist checklist = checklistRepo.findById(checklistId)
                .orElseThrow(() -> new RuntimeException("Checklist não encontrado"));

        ChecklistItem item = new ChecklistItem();
        item.setDescricao(dto.getDescricao());
        item.setConforme(false);
        item.setChecklist(checklist);

        return repo.save(item);
    }

    public List<ChecklistItem> listByChecklist(UUID checklistId) {
        return repo.findByChecklistId(checklistId);
    }

    public ChecklistItem update(UUID id, UpdateChecklistItemDTO dto) {
        ChecklistItem item = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        item.setConforme(dto.isConforme());
        item.setObservacao(dto.getObservacao());

        return repo.save(item);
    }
}
