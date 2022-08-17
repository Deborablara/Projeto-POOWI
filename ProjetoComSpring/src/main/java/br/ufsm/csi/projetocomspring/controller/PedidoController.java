package br.ufsm.csi.projetocomspring.controller;

import br.ufsm.csi.projetocomspring.dao.ClienteDAO;
import br.ufsm.csi.projetocomspring.dao.PedidoDAO;
import br.ufsm.csi.projetocomspring.dao.ProdutoDAO;
import br.ufsm.csi.projetocomspring.dao.VeiculoDAO;
import br.ufsm.csi.projetocomspring.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @GetMapping()
    public String pedidos(Model model) {
        model.addAttribute("pedidos", new PedidoDAO().getPedidos());
        model.addAttribute("produtos", new ProdutoDAO().getProdutos());
        model.addAttribute("clientes", new ClienteDAO().getClientes());
        model.addAttribute("veiculos", new VeiculoDAO().getVeiculos());

        return "pedido";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@RequestParam("produto") int idProduto, @RequestParam("quantidade")
        float quantidade, @RequestParam("cliente") int idCliente, @RequestParam("veiculo") int idVeiculo,
                            @RequestParam("dataEntrega") Date dataEntrega, @RequestParam("status") int idStatus, Model model){
        Produto p = new Produto(idProduto);
        Cliente c = new Cliente(idCliente);
        Veiculo v = new Veiculo(idVeiculo);
        Status s = new Status(idStatus);
        Pedido pedido = new Pedido(p, c, dataEntrega, quantidade,s, v);
        String retorno = new PedidoDAO().Cadastrar(pedido);
        model.addAttribute("pedidos", new PedidoDAO().getPedidos());
        model.addAttribute("produtos", new ProdutoDAO().getProdutos());
        model.addAttribute("clientes", new ClienteDAO().getClientes());
        model.addAttribute("veiculos", new VeiculoDAO().getVeiculos());
        model.addAttribute("retorno", retorno);

        return "pedido";
    }

    @GetMapping("/verPedidos")
    public String verPedido(@RequestParam("id") int idPedido, Model model){
        model.addAttribute("produtos", new ProdutoDAO().getProdutos());
        model.addAttribute("clientes", new ClienteDAO().getClientes());
        model.addAttribute("veiculos", new VeiculoDAO().getVeiculos());
        model.addAttribute("pedido", new PedidoDAO().getPedido(idPedido));
        return("VerPedido");
    }

    @PostMapping("/editar")
    public String editar(@RequestParam("id") int idPedido, @RequestParam("produto") int idProduto, @RequestParam("quantidade")
    float quantidade, @RequestParam("cliente") int idCliente, @RequestParam("veiculo") int idVeiculo,
                         @RequestParam("dataEntrega") Date dataEntrega, @RequestParam("dataPedido") Date dataPedido, @RequestParam("status") int idStatus, Model model){
        Produto p = new Produto(idProduto);
        Cliente c = new Cliente(idCliente);
        Veiculo v = new Veiculo(idVeiculo);
        Status s = new Status(idStatus);
        Pedido pedido = new Pedido(p, c, dataEntrega, quantidade, s, v,dataPedido);
        pedido.setId(idPedido);

        String retorno = new PedidoDAO().Editar(pedido);

        model.addAttribute("pedidos", new PedidoDAO().getPedidos());
        model.addAttribute("retorno", retorno);

        return "pedido";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam("id") int id, Model model){
        System.out.println(id);
        String retorno = new PedidoDAO().Excluir(id);
        model.addAttribute("retorno", retorno);
        model.addAttribute("pedidos", new PedidoDAO().getPedidos());

        return "pedido";
    }

}
