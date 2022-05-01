package br.ufsm.csi.util;

import br.ufsm.csi.dao.ConectaDB;
import br.ufsm.csi.dao.UsuarioDAO;
import br.ufsm.csi.model.Permissao;
import br.ufsm.csi.model.Usuario;

public class teste {
    public static void main(String args[]){
        CadastrarUsuario();
        TesteGetUser();
    }

    public static void TesteGetUser(){
        for(Usuario u : new UsuarioDAO().getUsuario()){
            System.out.println(u.getNome());
            System.out.println(u.getPermissao().getNomePermissao());
        }
    }

    public static void CadastrarUsuario(){
        Permissao p = new Permissao( 1,"Colaborador");

        Usuario u = new Usuario("Lucas", "1234", p);
        new UsuarioDAO().Cadastrar(u);
        System.out.println(p.getNomePermissao());
    }
}
