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
                    permissao.setNome(this.rs.getString("nome"));

                    usuario.setPermissao(permissao);

                    usuarios.add(usuario);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        return usuarios;
    }
}
