package br.ufsm.csi.projetocomspring.service;

import br.ufsm.csi.projetocomspring.dao.UsuarioDAO;
import br.ufsm.csi.projetocomspring.model.Usuario;

import javax.servlet.http.HttpServlet;

public class UsuarioService {
    public Usuario Autenticado(String usuario, String senha){

        Usuario u = new UsuarioDAO().getUsuario(usuario, senha);

        try{
            if(u.getNome().equals(usuario) && u.getPassword().equals(senha)){
                System.out.println(u.getNome());
                System.out.println(u.getPermissao().getNomePermissao());
                return u;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }
}
