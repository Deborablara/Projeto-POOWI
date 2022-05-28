package br.ufsm.csi.controller;

import br.ufsm.csi.model.Usuario;
import br.ufsm.csi.service.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("usuario");
        String senha = req.getParameter("senha");
        RequestDispatcher rd;

        Usuario u = new UsuarioService().Autenticado(nome, senha);

        if( u != null){
            HttpSession sessao = req.getSession();
             rd = req.getRequestDispatcher("dashboard.jsp");
        }else{
            rd = req.getRequestDispatcher("login.jsp");
        }

        rd.forward(req,resp);
    }
}
