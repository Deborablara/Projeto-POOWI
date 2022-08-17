package br.ufsm.csi.projetocomspring.dao;

import br.ufsm.csi.projetocomspring.model.Veiculo;

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
                v.setId(this.rs.getInt("id_veiculo"));
                v.setPlaca(this.rs.getString("placa"));
                v.setIsAtivo(this.rs.getBoolean("isativo"));
                veiculos.add(v);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return veiculos;
    }

    public String Cadastrar(Veiculo veiculo){
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO veiculo(placa, isativo) VALUES (?, true)";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, veiculo.getPlaca());
            this.preparedStatement.execute();
            this.rs = this.preparedStatement.getGeneratedKeys();
            this.rs.next();

            if (this.rs.getInt(1) > 0) {
                veiculo.setId(this.rs.getInt(1));
                this.status = "OK";
            }
            this.status = "OK";
        }catch(SQLException e){
            e.printStackTrace();
            this.status = "erro";
        }
        return this.status;
    }

    public Veiculo GetVeiculo(String placa){
        Veiculo v = new Veiculo();
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM veiculo where placa=?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, placa);
            this.rs = this.preparedStatement.executeQuery();

            while(this.rs.next()){
                v.setId(this.rs.getInt("id_veiculo"));
                v.setPlaca(this.rs.getString("placa"));
                v.setIsAtivo(this.rs.getBoolean("isativo"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return v;
    }

    public String Editar(Veiculo v){
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "Update veiculo set placa=? where id_veiculo=?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, v.getPlaca());
            this.preparedStatement.setInt(2, v.getId());
            this.preparedStatement.executeUpdate();
            this.status = "OK";
        }catch (SQLException e){
            e.printStackTrace();
            this.status = "ERRO";
        }

        return this.status;
    }

    public String Excluir(int  id){
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "update veiculo set isativo=false where id_veiculo=?";
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
