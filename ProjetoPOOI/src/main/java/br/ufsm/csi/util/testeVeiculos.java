package br.ufsm.csi.util;

import br.ufsm.csi.dao.VeiculoDAO;
import br.ufsm.csi.model.Veiculo;

public class testeVeiculos {
    public static void main(String args[]){
        ListarVeiculos();
    }
    public static void ListarVeiculos(){
        for(Veiculo v : new VeiculoDAO().getVeiculos()){
            System.out.println(v.getPlaca());
        }
    }
}
