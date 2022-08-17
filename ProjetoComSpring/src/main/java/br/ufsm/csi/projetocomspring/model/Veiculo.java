package br.ufsm.csi.projetocomspring.model;

public class Veiculo {
    private String placa;
    private int id;

    private boolean isAtivo;

    public Veiculo() {
    }
    public Veiculo(int id) {
        this.id= id;
    }
    public Veiculo(String placa) {
        this.placa = placa;
    }

    public Veiculo(String placa, int id) {

        this.placa = placa;
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Boolean getIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(Boolean isAtivo) {
        this.isAtivo = isAtivo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
