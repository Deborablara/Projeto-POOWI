package br.ufsm.csi.model;

public class Usuario {
    private int id;
    private String nome;
    private String password;
    private Permissao permissao;

    public Usuario(String nome, String password, Permissao permissao) {
        this.nome = nome;
        this.password = password;
        this.permissao = permissao;
    }

    public Usuario() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
}
