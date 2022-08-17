package br.ufsm.csi.projetocomspring.dao;

import br.ufsm.csi.projetocomspring.model.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PedidoDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public String Cadastrar(Pedido p){
        try(Connection connection = new ConectaDB().getConexao()) {
            Status statusPedido = new Status(1);
            p.setStatus(statusPedido);
            this.sql = "insert into pedido(quantidade, data_pedido, data_entrega, id_cliente, id_produto, id_status, id_veiculo, isativo) values (?, current_timestamp, ?, ?, ?, ?, ?, true)";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setFloat(1, p.getQuantidade());
            this.preparedStatement.setDate(2, p.getDataEntrega());
            this.preparedStatement.setInt(3, p.getCliente().getId());
            this.preparedStatement.setInt(4, p.getProduto().getId());
            this.preparedStatement.setInt(5, p.getStatus().getId());
            this.preparedStatement.setInt(6, p.getVeiculo().getId());
            this.preparedStatement.execute();
            this.rs = this.preparedStatement.getGeneratedKeys();
            this.rs.next();

            if (this.rs.getInt(1) > 0) {
                p.setId(this.rs.getInt(1));
                this.status = "OK";
            }


        }catch (SQLException e){
            e.printStackTrace();
            this.status = "erro";
        }

        return this.status;
    }

    public ArrayList<Pedido> getPedidos(){
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "select * from pedido, cliente, produto, veiculo, status " +
                    "where cliente.id_cliente = pedido.id_cliente and produto.id_produto = pedido.id_produto and veiculo.id_veiculo = pedido.id_veiculo " +
                    "and status.id_status = pedido.id_status";

            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(this.sql);

            while(this.rs.next()){
                Pedido pedido = new Pedido();

                pedido.setId(this.rs.getInt("id_pedido"));
                pedido.setQuantidade(this.rs.getFloat("quantidade"));

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                pedido.setDataPedido(this.rs.getDate("data_pedido"));
                pedido.setDataEntrega(this.rs.getDate("data_entrega"));
                pedido.setIsAtivo(this.rs.getBoolean("isativo"));

                Cliente c = new Cliente();
                c.setId(this.rs.getInt("id_cliente"));
                c.setNome(this.rs.getString("nome_cliente"));

                Produto p = new Produto();
                p.setId(this.rs.getInt("id_produto"));
                p.setNome(this.rs.getString("nome_produto"));

                Veiculo v = new Veiculo();
                v.setId(this.rs.getInt("id_veiculo"));
                v.setPlaca(this.rs.getString("placa"));

                Status status = new Status();
                status.setId(this.rs.getInt("id_status"));
                status.setNome(this.rs.getString("nome_status"));

                pedido.setCliente(c);
                pedido.setProduto(p);
                pedido.setVeiculo(v);
                pedido.setStatus(status);

                pedidos.add(pedido);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return pedidos;
    }

    public Pedido getPedido(int id){
        Pedido pedido = new Pedido();

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "select * from pedido, cliente, produto, veiculo, status " +
                    "where cliente.id_cliente = pedido.id_cliente and produto.id_produto = pedido.id_produto and veiculo.id_veiculo = pedido.id_veiculo " +
                    "and status.id_status = pedido.id_status and pedido.id_pedido=?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.rs = this.preparedStatement.executeQuery();

            while(this.rs.next()){
                pedido.setId(this.rs.getInt("id_pedido"));
                pedido.setQuantidade(this.rs.getFloat("quantidade"));

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                pedido.setDataPedido(this.rs.getDate("data_pedido"));
                pedido.setDataEntrega(this.rs.getDate("data_entrega"));
                pedido.setIsAtivo(this.rs.getBoolean("isativo"));

                Cliente c = new Cliente();
                c.setId(this.rs.getInt("id_cliente"));
                c.setNome(this.rs.getString("nome_cliente"));

                Produto p = new Produto();
                p.setId(this.rs.getInt("id_produto"));
                p.setNome(this.rs.getString("nome_produto"));

                Veiculo v = new Veiculo();
                v.setId(this.rs.getInt("id_veiculo"));
                v.setPlaca(this.rs.getString("placa"));

                Status status = new Status();
                status.setId(this.rs.getInt("id_status"));
                status.setNome(this.rs.getString("nome_status"));

                pedido.setCliente(c);
                pedido.setProduto(p);
                pedido.setVeiculo(v);
                pedido.setStatus(status);


            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return pedido;
    }

    public String Editar(Pedido p){
        try(Connection connection = new ConectaDB().getConexao()) {
            this.sql = "update pedido set quantidade=?, data_pedido=?, data_entrega=?, id_cliente=?, id_produto=?, id_status=?, id_veiculo=? where id_pedido=?";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setFloat(1, p.getQuantidade());
            this.preparedStatement.setDate(2, p.getDataPedido());
            this.preparedStatement.setDate(3, p.getDataEntrega());
            this.preparedStatement.setInt(4, p.getCliente().getId());
            this.preparedStatement.setInt(5, p.getProduto().getId());
            this.preparedStatement.setInt(6, p.getStatus().getId());
            this.preparedStatement.setInt(7, p.getVeiculo().getId());
            this.preparedStatement.setInt(8, p.getId());
            this.preparedStatement.executeUpdate();

            this.status = "OK";



        }catch (SQLException e){
            e.printStackTrace();
            this.status = "erro";
        }

        return this.status;
    }

    public String Excluir(int id){
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "update pedido set isativo=false where id_pedido=?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();
            this.status = "OK";
        }catch (SQLException e){
            e.printStackTrace();
            this.status = "ERRO";
        }

        return this.status;
    }
}
