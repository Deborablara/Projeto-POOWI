package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ClienteDAO;
import br.ufsm.csi.dao.ProdutoDAO;
import br.ufsm.csi.dao.UsuarioDAO;
import br.ufsm.csi.dao.VeiculoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("dashboard")
public class DashboardController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        String uri = " ";

        switch (opcao){
            case "pedidos":
                uri = "pedido.jsp";

                break;

            case "clientes":
                req.setAttribute("clientes", new ClienteDAO().getClientes());
                uri = "cliente.jsp";
                break;

            case "veiculos":
                req.setAttribute("veiculos", new VeiculoDAO().getVeiculos());
                uri = "veiculo.jsp";
                break;

            case "funcionarios":
                req.setAttribute("usuarios", new UsuarioDAO().getUsuarios());
                uri = "funcionario.jsp";
                break;

            case "produtos":
                req.setAttribute("produtos", new ProdutoDAO().getProdutos());
                uri = "produto.jsp";
                break;

            case "logout":
                req.getSession().invalidate();
                uri = "/";
                break;

            default:
                uri = " ";
        }
        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);
    }
}
