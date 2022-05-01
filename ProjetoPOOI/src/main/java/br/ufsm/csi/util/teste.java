package br.ufsm.csi.util;

import br.ufsm.csi.dao.ConectaDB;
import br.ufsm.csi.dao.UsuarioDAO;
import br.ufsm.csi.model.Usuario;

public class teste {
    public static void main(String args[]){
        TesteGetUser();
    }

    public static void TesteGetUser(){
        for(Usuario u : new UsuarioDAO().getUsuario()){
            System.out.println(u.getNome());
            System.out.println(u.getPermissao().getNome());
        }
    }
}
