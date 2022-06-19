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
        String senha = req.getParameter("acesso");
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

            case "excluir":
                int id = Integer.parseInt(req.getParameter("id"));
                retorno = dao.Deletar(id);
                if(retorno.equals("OK")){
                    req.setAttribute("usuarios", dao.getUsuarios());
                    uri = "funcionario.jsp";
                }
                break;
            case "ver":
                int idUs = Integer.parseInt(req.getParameter("id"));
                Usuario usuario = dao.GetUsuarioPermissao(idUs);
                req.setAttribute("usuario", usuario);

                uri = "VerUsuario.jsp";

                break;
            default:
                break;
        }

        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);
    }
}
