package br.ufsm.csi.controller;

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
                uri = "cliente.jsp";
                break;

            case "veiculos":
                uri = "veiculo.jsp";
                break;

            case "funcionarios":
                uri = "funcionario.jsp";
                break;

            case "produtos":
                uri = "produto.jsp";
                break;

            default:
                uri = " ";
        }
        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);
    }
}
