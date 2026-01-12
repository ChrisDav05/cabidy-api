package com.example.cabidy.Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "checklists")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Vehicle vehicle;

    private LocalDateTime criadoEm;
    private LocalDateTime finalizadoEm;

    private boolean assinadoTecnico;
    private boolean assinadoCliente;

    @OneToMany(mappedBy = "checklist", cascade = CascadeType.ALL)
    private List<ChecklistItem> itens;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getFinalizadoEm() {
        return finalizadoEm;
    }

    public void setFinalizadoEm(LocalDateTime finalizadoEm) {
        this.finalizadoEm = finalizadoEm;
    }

    public boolean isAssinadoTecnico() {
        return assinadoTecnico;
    }

    public void setAssinadoTecnico(boolean assinadoTecnico) {
        this.assinadoTecnico = assinadoTecnico;
    }

    public boolean isAssinadoCliente() {
        return assinadoCliente;
    }

    public void setAssinadoCliente(boolean assinadoCliente) {
        this.assinadoCliente = assinadoCliente;
    }

    public List<ChecklistItem> getItens() {
        return itens;
    }

    public void setItens(List<ChecklistItem> itens) {
        this.itens = itens;
    }
}