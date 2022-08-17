package br.ufsm.csi.projetocomspring.controller;

import br.ufsm.csi.projetocomspring.dao.ProdutoDAO;
import br.ufsm.csi.projetocomspring.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("produto")
public class Produtoscontroller {
    @GetMapping("")
    public String produtos(Model model) {
        model.addAttribute("produtos", new ProdutoDAO().getProdutos());
        return "produto";
    }

    @PostMapping("/cadastrar")
    public  String cadastrarProduto(@ModelAttribute("produto") Produto produto, Model model){
        String retorno = new ProdutoDAO().Cadastrar(produto);
        model.addAttribute("produtos", new ProdutoDAO().getProdutos());
        model.addAttribute("retorno", retorno);

        return "produto";
    }

    @GetMapping("/verProduto")
    public  String verProduto(@RequestParam("id") int id, Model model){
        model.addAttribute("produto", new ProdutoDAO().getProduto(id));
        return "VerProduto";
    }

    @PostMapping("/editar-produto")
    public  String editarProduto(@ModelAttribute("produto") Produto produto, Model model){
        String retorno = new ProdutoDAO().Editar(produto);

        if(retorno.equals("OK")){
            model.addAttribute("produtos", new ProdutoDAO().getProdutos());
            return "produto";
        }else{
            model.addAttribute("produto", new ProdutoDAO().getProduto(produto.getId()));
            return "VerProduto";
        }
    }

    @GetMapping("excluir")
    public String excluir(@RequestParam("id") int idProduto, Model model){
        String  retorno = new ProdutoDAO().Excluir(idProduto);
        model.addAttribute("retorno", retorno);
        model.addAttribute("produtos", new ProdutoDAO().getProdutos());

        return "produto";
    }




}
