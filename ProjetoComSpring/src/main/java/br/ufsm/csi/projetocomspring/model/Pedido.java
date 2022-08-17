package br.ufsm.csi.projetocomspring.model;

import java.sql.Date;

public class Pedido {
    private int id;
    private Produto produto;
    private float quantidade;
    private Cliente cliente;
    private Date dataPedido;
    private Date dataEntrega;
    private Status status;
    private Veiculo veiculo;

    private Boolean isAtivo;

    public Pedido(){

    }

    public Pedido(Produto produto, Cliente cliente, Date dataEntrega, float quantidade, Status status, Veiculo veiculo){
        this.produto = produto;
        this.cliente = cliente;
        this.dataEntrega = dataEntrega;
        this.quantidade = quantidade;
        this.status = status;
        this.veiculo = veiculo;

    }
    public Pedido(Produto produto, Cliente cliente, Date dataEntrega, float quantidade, Status status, Veiculo veiculo, Date dataPedido){
        this.produto = produto;
        this.cliente = cliente;
        this.dataEntrega = dataEntrega;
        this.quantidade = quantidade;
        this.status = status;
        this.veiculo = veiculo;
        this.dataPedido = dataPedido;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setIsAtivo(Boolean isAtivo) {
        this.isAtivo = isAtivo;
    }

    public Boolean getIsAtivo() {
        return isAtivo;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }



}
