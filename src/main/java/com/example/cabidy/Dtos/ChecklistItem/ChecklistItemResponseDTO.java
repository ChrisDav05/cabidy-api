package com.example.cabidy.Dtos.ChecklistItem;

import java.util.UUID;

public class ChecklistItemResponseDTO {

    private UUID id;
    private String descricao;
    private boolean conforme;
    private String observacao;

    public ChecklistItemResponseDTO(
            UUID id,
            String descricao,
            boolean conforme,
            String observacao
    ) {
        this.id = id;
        this.descricao = descricao;
        this.conforme = conforme;
        this.observacao = observacao;
    }

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConforme() {
        return conforme;
    }

    public String getObservacao() {
        return observacao;
    }
}
