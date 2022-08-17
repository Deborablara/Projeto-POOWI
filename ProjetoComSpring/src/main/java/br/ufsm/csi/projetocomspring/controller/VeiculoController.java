package br.ufsm.csi.projetocomspring.controller;

import br.ufsm.csi.projetocomspring.dao.ClienteDAO;
import br.ufsm.csi.projetocomspring.dao.VeiculoDAO;
import br.ufsm.csi.projetocomspring.model.Cliente;
import br.ufsm.csi.projetocomspring.model.Veiculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
    @GetMapping()
    public String VeiculosPage(Model model){
        model.addAttribute("veiculos", new VeiculoDAO().getVeiculos());
        return "veiculo";
    }

    @PostMapping("/cadastrar")
    public String cadastrarVeiculo(@ModelAttribute("veiculo") Veiculo veiculo, Model model){
        String retorno = new VeiculoDAO().Cadastrar(veiculo);
        model.addAttribute("veiculos", new VeiculoDAO().getVeiculos());
        model.addAttribute("retorno", retorno);
        return "veiculo";

    }

    @PostMapping("/editar")
    public String editarVeiculo(@ModelAttribute("veiculo") Veiculo veiculo, Model model){
        String retorno = new VeiculoDAO().Editar(veiculo);

        if(retorno.equals("OK")){
            model.addAttribute("veiculos", new VeiculoDAO().getVeiculos());
            return "veiculo";
        }else{
            model.addAttribute("veiculo", new VeiculoDAO().GetVeiculo(veiculo.getPlaca()));
            return "VerVeiculo";
        }

    }

    @GetMapping("/verVeiculo")
    public String verVeiculo(@RequestParam("placa") String placa, Model model){
        model.addAttribute("veiculo", new VeiculoDAO().GetVeiculo(placa));
        return("VerVeiculo");
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam("id") int idVeiculo, Model model){
        String retorno = new VeiculoDAO().Excluir(idVeiculo);
        model.addAttribute("retorno", retorno);
        model.addAttribute("veiculos", new VeiculoDAO().getVeiculos());
        return "veiculo";
    }
}
