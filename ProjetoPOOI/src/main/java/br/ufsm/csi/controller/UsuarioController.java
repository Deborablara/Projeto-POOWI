package br.ufsm.csi.controller;

import br.ufsm.csi.dao.UsuarioDAO;
import br.ufsm.csi.model.Permissao;
import br.ufsm.csi.model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("usuario")
public class UsuarioController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        int permissao = Integer.parseInt(req.getParameter("permissao"));
        Permissao p = new Permissao(permissao);
        Usuario u = new Usuario(nome, senha, p);
        UsuarioDAO dao = new UsuarioDAO();
        String uri = " ";
        String retorno = "";

        switch (opcao){

            case "cadastrar":
                retorno = dao.Cadastrar(u);
                req.setAttribute("retorno", retorno);
                req.setAttribute("usuarios", dao.getUsuarios());

                uri = "funcionario.jsp";

                break;
        }

        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);
    }
}
