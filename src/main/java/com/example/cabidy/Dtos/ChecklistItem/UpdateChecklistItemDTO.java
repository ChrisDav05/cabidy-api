package com.example.cabidy.Dtos.ChecklistItem;

public class UpdateChecklistItemDTO {

    private boolean conforme;
    private String observacao;

    public boolean isConforme() {
        return conforme;
    }

    public void setConforme(boolean conforme) {
        this.conforme = conforme;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
