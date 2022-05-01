package br.ufsm.csi.model;

public class Permissao {
    private int id;
    private String nomePermissao;

    public Permissao() {
    }

    public Permissao( int id, String nomePermissao) {
        this.nomePermissao = nomePermissao;
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePermissao() {
        return nomePermissao;
    }

    public void setNome(String nomePermissao) {
        this.nomePermissao = nomePermissao;
    }
}
