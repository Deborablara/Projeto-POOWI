package br.ufsm.csi.dao;

import br.ufsm.csi.model.Permissao;
import br.ufsm.csi.model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {

    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<Usuario> getUsuario(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            try(Connection connection = new ConectaDB().getConexao()){
                this.sql = "select * from usuario_permissao, usuario, permissao" +
                        " where usuario.id_usuario = usuario_permissao.id_usuario " +
                        "and permissao.id_permissao = usuario_permissao.id_permissao;";
                this.stmt = connection.createStatement();
                this.rs = stmt.executeQuery(sql);

                while (this.rs.next()){
                    Usuario usuario = new Usuario();

                    usuario.setId(this.rs.getInt("id_usuario"));
                    usuario.setNome(this.rs.getString("nome"));
                    usuario.setPassword(this.rs.getString("password"));

                    Permissao permissao = new Permissao();
                    permissao.setId(this.rs.getInt("id_permissao"));
                    permissao.setNome(this.rs.getString("nome_permissao"));

                    usuario.setPermissao(permissao);

                    usuarios.add(usuario);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        return usuarios;
    }

    public String Cadastrar(Usuario u){
        try(Connection connection = new ConectaDB().getConexao()){
            connection.setAutoCommit(false);

            this.sql = "insert into usuario(nome, password) VALUES (?, ?)";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, u.getNome());
            this.preparedStatement.setString(2, u.getPassword());
            this.preparedStatement.execute();
            this.rs = this.preparedStatement.getGeneratedKeys();
            this.rs.next();

            if(this.rs.getInt(1) > 0){
                u.setId(this.rs.getInt(1));
                this.status = "OK";
            }

            if(this.status.equals("OK")) {
                this.sql = "INSERT INTO usuario_permissao(id_usuario, id_permissao)" +
                        "VALUES (?, ?)";
                this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
                this.preparedStatement.setInt(1, u.getId());
                this.preparedStatement.setInt(2, u.getPermissao().getId());

                this.preparedStatement.execute();
                this.rs = this.preparedStatement.getGeneratedKeys();
                this.rs.next();

                if(this.rs.getInt(1) > 0){
                    connection.setAutoCommit(true);
                    this.status = "OK";
                }

            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.status;
    }
}
