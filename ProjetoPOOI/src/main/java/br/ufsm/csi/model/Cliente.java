package br.ufsm.csi.model;

public class Cliente {

    private int id;
    private String nome;

    public Cliente(){

    }
    public Cliente(String nome){
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}