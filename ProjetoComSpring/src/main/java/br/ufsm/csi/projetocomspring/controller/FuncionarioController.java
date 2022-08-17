package br.ufsm.csi.projetocomspring.controller;

import br.ufsm.csi.projetocomspring.dao.ClienteDAO;
import br.ufsm.csi.projetocomspring.dao.ProdutoDAO;
import br.ufsm.csi.projetocomspring.dao.UsuarioDAO;
import br.ufsm.csi.projetocomspring.model.Cliente;
import br.ufsm.csi.projetocomspring.model.Permissao;
import br.ufsm.csi.projetocomspring.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class FuncionarioController {
    @GetMapping()
    public String funcionario(Model model) {
        model.addAttribute("usuarios", new UsuarioDAO().getUsuarios());
        return "funcionario";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@RequestParam("nome") String nome,@RequestParam("senha") String senha, @RequestParam("permissao") int idPermissao, Model model) {
        Permissao p = new Permissao(idPermissao);
        Usuario usuario = new Usuario(nome, senha, p);
        String retorno = new UsuarioDAO().Cadastrar(usuario);
        model.addAttribute("usuarios", new UsuarioDAO().getUsuarios());
        model.addAttribute("retorno", retorno);
        return "funcionario";
    }

    @GetMapping("/verUsuario")
    public String verUsuario(@RequestParam("id") int idUsuario, Model model){
        model.addAttribute("usuario", new UsuarioDAO().GetUsuarioPermissao(idUsuario));
        return "VerUsuario";
    }

    @PostMapping("/editar")
    public String editar(@RequestParam("nome") String nome,@RequestParam("senha") String senha, @RequestParam("permissao") int idPermissao, @RequestParam("id") int idUsuario,  Model model){
        Permissao p = new Permissao(idPermissao);
        Usuario usuario = new Usuario(nome, senha, p, idUsuario);
        String retorno = new UsuarioDAO().Editar(usuario);
        model.addAttribute("retorno", retorno);
        model.addAttribute("usuarios", new UsuarioDAO().getUsuarios());

        return "funcionario";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam("id") int idUsuario, Model model){
        String retorno =  new UsuarioDAO().Deletar(idUsuario);
        model.addAttribute("retorno", retorno);
        model.addAttribute("usuarios", new UsuarioDAO().getUsuarios());

        return("funcionario");
    }


}
