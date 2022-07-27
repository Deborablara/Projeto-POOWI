package br.ufsm.csi.projetocomspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDB {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/Projeto-POOI";
    private static final String PASS = "postgres";
    private static final String SENHA = "1234";

    public Connection getConexao(){

        Connection conn = null;

        try{
            Class.forName(this.DRIVER);
            conn = DriverManager.getConnection(this.URL, this.PASS, this.SENHA);

        }catch (Exception e){
            e.printStackTrace();
        }


        return conn;
    }
}
