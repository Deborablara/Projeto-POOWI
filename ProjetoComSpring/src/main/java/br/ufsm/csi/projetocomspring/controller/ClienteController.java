package br.ufsm.csi.projetocomspring.controller;

import br.ufsm.csi.projetocomspring.dao.ClienteDAO;
import br.ufsm.csi.projetocomspring.dao.ProdutoDAO;
import br.ufsm.csi.projetocomspring.model.Cliente;
import br.ufsm.csi.projetocomspring.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @GetMapping()
    public String ClientesPage(Model model){
        model.addAttribute("clientes", new ClienteDAO().getClientes());
        return "cliente";
    }

    @PostMapping("/cadastrar")
    public String cadastrarCliente(@ModelAttribute("cliente") Cliente cliente, Model model){
        String retorno = new ClienteDAO().Cadastrar(cliente);
        model.addAttribute("clientes", new ClienteDAO().getClientes());
        model.addAttribute("retorno", retorno);
        return "cliente";

    }

    @GetMapping("/verCliente")
    public String verCliente(@RequestParam("id") int id, Model model){
        model.addAttribute("cliente", new ClienteDAO().GetCliente(id));
        return("Vercliente");
    }

    @PostMapping("/editar")
    public String editarCliente(@ModelAttribute("cliente") Cliente cliente, Model model){
        String retorno = new ClienteDAO().Editar(cliente);

        if(retorno.equals("OK")){
            model.addAttribute("clientes", new ClienteDAO().getClientes());
            return "cliente";
        }else{
            model.addAttribute("cliente", new ClienteDAO().GetCliente(cliente.getId()));
            return "Vercliente";
        }
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam("id") int id, Model model){
        String retorno = new ClienteDAO().Excluir(id);
        model.addAttribute("retorno", retorno);
        model.addAttribute("clientes", new ClienteDAO().getClientes());

        return "cliente";
    }
}
