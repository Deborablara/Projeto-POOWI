package br.ufsm.csi.controller;

import br.ufsm.csi.dao.*;
import br.ufsm.csi.model.Usuario;

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
                req.setAttribute("pedidos", new PedidoDAO().getPedidos());
                req.setAttribute("produtos", new ProdutoDAO().getProdutos());
                req.setAttribute("clientes", new ClienteDAO().getClientes());
                req.setAttribute("veiculos", new VeiculoDAO().getVeiculos());

                uri = "WEB-INF/Pedido.jsp";

                break;

            case "clientes":
                req.setAttribute("clientes", new ClienteDAO().getClientes());
                uri = "WEB-INF/cliente.jsp";
                break;

            case "veiculos":
                req.setAttribute("veiculos", new VeiculoDAO().getVeiculos());
                uri = "WEB-INF/veiculo.jsp";
                break;

            case "funcionarios":
                req.setAttribute("usuarios", new UsuarioDAO().getUsuarios());
                uri = "WEB-INF/funcionario.jsp";
                break;

            case "produtos":
                req.setAttribute("produtos", new ProdutoDAO().getProdutos());
                uri = "WEB-INF/produto.jsp";
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
