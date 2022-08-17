package br.ufsm.csi.projetocomspring.model;

public class Usuario {
    private int id;
    private String nome;
    private String password;
    private Permissao permissao;

    private Boolean isAtivo;

    public Usuario(String nome, String password, Permissao permissao) {
        this.nome = nome;
        this.password = password;
        this.permissao = permissao;
    }
    public Usuario(String nome, String password, Permissao permissao, int id) {
        this.nome = nome;
        this.password = password;
        this.permissao = permissao;
        this.id = id;
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

    public Boolean getIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(Boolean isAtivo) {
        this.isAtivo = isAtivo;
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
