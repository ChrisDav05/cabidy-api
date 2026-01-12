package com.example.cabidy.Dtos.VehicleDto;

public class VehicleCreateDTO {

    //@NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    //@NotBlank(message = "A placa é obrigatória")
    //@Size(min = 7, max = 8, message = "A placa deve ter entre 7 e 8 caracteres")
    private String placa;

    //@NotBlank(message = "O chassi é obrigatório")
    private String chassi;

    //@NotBlank(message = "O nome do cliente é obrigatório")
    private String cliente;

    // Construtor vazio (obrigatório para o Spring)
    public VehicleCreateDTO() {
    }

    // Getters e Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
