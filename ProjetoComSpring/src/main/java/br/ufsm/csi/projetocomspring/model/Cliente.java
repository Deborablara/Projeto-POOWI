package br.ufsm.csi.projetocomspring.model;

public class Cliente {

    private int id;
    private String nome;
    private Boolean isAtivo;

    public Cliente(){

    }
    public Cliente(String nome){
        this.nome = nome;
    }
    public Cliente(int id){
        this.id = id;
    }
    public Cliente(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Boolean getIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(Boolean isAtivo) {
        this.isAtivo = isAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
