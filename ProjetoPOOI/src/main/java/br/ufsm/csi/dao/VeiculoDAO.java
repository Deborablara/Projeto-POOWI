package br.ufsm.csi.dao;

import br.ufsm.csi.model.Veiculo;

import java.sql.*;
import java.util.ArrayList;

public class VeiculoDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<Veiculo> getVeiculos(){
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM veiculo";
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(this.sql);

            while(this.rs.next()){
                Veiculo v = new Veiculo();
                v.setPlaca(this.rs.getString("placa"));
                veiculos.add(v);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return veiculos;
    }

    public String Cadastrar(Veiculo veiculo){
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO veiculo(placa) VALUES (?)";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, veiculo.getPlaca());

            this.preparedStatement.execute();
            this.status = "OK";
        }catch(SQLException e){
            e.printStackTrace();
            this.status = "erro";
        }
        return this.status;
    }



}
