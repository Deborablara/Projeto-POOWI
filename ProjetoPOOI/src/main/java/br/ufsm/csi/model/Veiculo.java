package br.ufsm.csi.model;

public class Veiculo {
    private String placa;
    private int id;

    public Veiculo() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
