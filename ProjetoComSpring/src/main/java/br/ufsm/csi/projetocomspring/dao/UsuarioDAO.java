package br.ufsm.csi.projetocomspring.dao;

import br.ufsm.csi.projetocomspring.model.Permissao;
import br.ufsm.csi.projetocomspring.model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {

    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public Usuario getUsuario(String usuario, String senha){
        Usuario us = null;

        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "select * from usuario_permissao, usuario, permissao" +
                    "                    where usuario.id_usuario = usuario_permissao.id_usuario" +
                    "                    and permissao.id_permissao = usuario_permissao.id_permissao and usuario.nome=? and usuario.password = ?;";

            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setString(1, usuario);
            this.preparedStatement.setString(2, senha);
            this.rs = preparedStatement.executeQuery();

            System.out.println("GetUsuario" + this.preparedStatement);

            while(this.rs.next()){
                us = new Usuario();
                us.setId(this.rs.getInt("id_usuario"));
                us.setNome(this.rs.getString("nome"));
                us.setPassword(this.rs.getString("password"));
                us.setIsAtivo(this.rs.getBoolean("isativo"));

                Permissao p = new Permissao();
                p.setId(this.rs.getInt("id_permissao"));
                p.setNome(this.rs.getString("nome_permissao"));
                us.setPermissao(p);
                System.out.println(us.getPermissao().getId());


                return us;
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return us;

    }

    public Usuario GetUsuarioPermissao(int id){
        Usuario us = null;

        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "select * from usuario_permissao, usuario, permissao" +
                    " where usuario.id_usuario = usuario_permissao.id_usuario " +
                    "and permissao.id_permissao = usuario_permissao.id_permissao and usuario.id_usuario=?;";

            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.rs = preparedStatement.executeQuery();

            while(this.rs.next()){
                us = new Usuario();
                us.setId(this.rs.getInt("id_usuario"));
                us.setNome(this.rs.getString("nome"));
                us.setPassword(this.rs.getString("password"));
                us.setIsAtivo(this.rs.getBoolean("isativo"));

                Permissao p = new Permissao();
                p.setId(this.rs.getInt("id_permissao"));
                p.setNome(this.rs.getString("nome_permissao"));
                us.setPermissao(p);

                return us;
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return us;
    }

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try (Connection connection = new ConectaDB().getConexao()) {
            this.sql = "select * from usuario_permissao, usuario, permissao" +
                    " where usuario.id_usuario = usuario_permissao.id_usuario " +
                    "and permissao.id_permissao = usuario_permissao.id_permissao;";
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(this.sql);

            while (this.rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(this.rs.getInt("id_usuario"));
                usuario.setNome(this.rs.getString("nome"));
                usuario.setPassword(this.rs.getString("password"));
                usuario.setIsAtivo(this.rs.getBoolean("isativo"));

                Permissao permissao = new Permissao();
                permissao.setId(this.rs.getInt("id_permissao"));
                permissao.setNome(this.rs.getString("nome_permissao"));

                usuario.setPermissao(permissao);

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }



    public String Cadastrar(Usuario u) {
        try (Connection connection = new ConectaDB().getConexao()) {
            connection.setAutoCommit(false);

            this.sql = "insert into usuario(nome, password, isativo) VALUES (?, ?, true)";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, u.getNome());
            this.preparedStatement.setString(2, u.getPassword());
            this.preparedStatement.execute();
            this.rs = this.preparedStatement.getGeneratedKeys();
            this.rs.next();

            if (this.rs.getInt(1) > 0) {
                u.setId(this.rs.getInt(1));
                this.status = "OK";
            }

            if (this.status.equals("OK")) {
                this.sql = "INSERT INTO usuario_permissao(id_usuario, id_permissao)" +
                        "VALUES (?, ?)";
                this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
                this.preparedStatement.setInt(1, u.getId());
                this.preparedStatement.setInt(2, u.getPermissao().getId());

                this.preparedStatement.execute();
                this.rs = this.preparedStatement.getGeneratedKeys();
                this.rs.next();

                if (this.rs.getInt(1) > 0) {
                    connection.setAutoCommit(true);
                    this.status = "OK";
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "erro";
        }
        return this.status;
    }

    public String Editar(Usuario u) {
        try (Connection connection = new ConectaDB().getConexao()) {

            this.sql = "BEGIN;" +
                    "UPDATE usuario SET nome=?, password=?  where id_usuario=?;" +
                    "UPDATE usuario_permissao SET id_permissao=? where id_usuario=?;" +
                    "COMMIT;";

            this.preparedStatement = connection.prepareStatement(this.sql);

            this.preparedStatement.setString(1, u.getNome());
            this.preparedStatement.setString(2, u.getPassword());
            this.preparedStatement.setInt(3, u.getId());
            this.preparedStatement.setInt(4, u.getPermissao().getId());
            this.preparedStatement.setInt(5, u.getId());
            this.preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String Deletar(int id){
        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "update usuario set isativo=false where id_usuario=?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();
            this.status = "OK";
        }catch (SQLException e){
            e.printStackTrace();
            this.status = "erro";
        }

        return this.status;
    }

}