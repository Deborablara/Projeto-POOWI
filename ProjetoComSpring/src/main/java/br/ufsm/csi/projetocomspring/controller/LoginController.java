package br.ufsm.csi.projetocomspring.controller;

import br.ufsm.csi.projetocomspring.model.Usuario;
import br.ufsm.csi.projetocomspring.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {
    @PostMapping
    public String autenticar(@RequestParam String nome, @RequestParam String senha, HttpSession sessao){
        Usuario u = new UsuarioService().Autenticado(nome, senha);
        if(u != null){
            sessao.setAttribute("usuario_logado", u);
            return "dashboard";
        }
        else{
            return "index";
        }

    }
    @GetMapping("/logout")
    public String logout(HttpSession sessao){
        sessao.invalidate();
        return "index";
    }
}
