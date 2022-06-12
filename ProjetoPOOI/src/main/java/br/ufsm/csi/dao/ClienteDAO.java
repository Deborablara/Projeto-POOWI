package br.ufsm.csi.dao;

import br.ufsm.csi.model.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM cliente";

            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(this.sql);

            while (this.rs.next()){
                Cliente c = new Cliente();

                c.setId(this.rs.getInt("id_cliente"));
                c.setNome(this.rs.getString("nome_cliente"));
                clientes.add(c);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return clientes;
    }

    public String Cadastrar(Cliente c){
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO cliente(nome) values (?)";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, c.getNome());
            this.preparedStatement.execute();

            this.status = "OK";

        }catch (SQLException e){
            e.printStackTrace();
            this.status = "erro";
        }

        return this.status;
    }
}


