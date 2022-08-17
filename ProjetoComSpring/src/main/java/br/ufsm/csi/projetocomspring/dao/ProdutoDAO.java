package br.ufsm.csi.projetocomspring.dao;

import br.ufsm.csi.projetocomspring.model.Produto;

import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<Produto> getProdutos(){
        ArrayList<Produto> produtos = new ArrayList<Produto>();

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM produto";
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(this.sql);

            while(this.rs.next()){
                Produto p = new Produto();

                p.setId(this.rs.getInt("id_produto"));
                p.setNome(this.rs.getString("nome_produto"));
                p.setIsAtivo(this.rs.getBoolean("isativo"));
                produtos.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return produtos;
    }


    public String Cadastrar(Produto p){
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO produto(nome_produto, isativo) VALUES (?, true)";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, p.getNome());
            this.preparedStatement.execute();

            this.status = "OK";

        }catch (SQLException e){
            e.printStackTrace();
            this.status = "erro";
        }

        return this.status;
    }

    public String Editar(Produto p){
        try(Connection connection = new ConectaDB().getConexao()){

            connection.setAutoCommit(false);
            this.sql = "UPDATE produto SET nome_produto=? where id_produto=?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, p.getNome());
            this.preparedStatement.setInt(2, p.getId());
            this.preparedStatement.executeUpdate();

            if (this.preparedStatement.getUpdateCount() > 0) {
                connection.commit();
                this.status = "OK";
            }

        }catch (SQLException e){
            e.printStackTrace();
            this.status = "ERRO";
        }

        return this.status;
    }

    public Produto getProduto(int id){
        Produto p = new Produto();

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM produto where id_produto = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.rs = this.preparedStatement.executeQuery();

            while(this.rs.next()){
                p.setId(this.rs.getInt("id_produto"));
                p.setNome(this.rs.getString("nome_produto"));
                p.setIsAtivo(this.rs.getBoolean("isativo"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return p;
    }

    public String Excluir (int id){
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "update produto set isativo=false where id_produto = ?";

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
