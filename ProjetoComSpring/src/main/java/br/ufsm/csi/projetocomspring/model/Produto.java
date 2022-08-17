package br.ufsm.csi.projetocomspring.model;

public class Produto {
    private int id;
    private String nome;

    private Boolean isAtivo;

    public Produto() {

    }
    public Produto(int id) {
        this.id = id;

    }
    public Produto(String nome) {
        this.nome = nome;
    }
    public Produto(String nome, int id) {
        this.nome = nome;
        this.id = id;
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
