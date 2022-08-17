package br.ufsm.csi.projetocomspring.service;

import br.ufsm.csi.projetocomspring.dao.UsuarioDAO;
import br.ufsm.csi.projetocomspring.model.Usuario;

import javax.servlet.http.HttpServlet;

public class UsuarioService {
    public Usuario Autenticado(String nome, String senha){

        Usuario u = new UsuarioDAO().getUsuario(nome, senha);

        try{
            if(u.getNome().equals(nome) && u.getPassword().equals(senha)){
                return u;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }
}
