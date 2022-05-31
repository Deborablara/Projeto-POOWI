package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ClienteDAO;
import br.ufsm.csi.dao.VeiculoDAO;
import br.ufsm.csi.model.Cliente;
import br.ufsm.csi.model.Veiculo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("cliente")
public class ClienteController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        String nome = req.getParameter("nome");
        Cliente c = new Cliente(nome);
        ClienteDAO dao = new ClienteDAO();
        String uri = " ";
        String retorno = "";

        switch (opcao){
            case "cadastrar":
                retorno = dao.Cadastrar(c);
                req.setAttribute("retorno", retorno);
                req.setAttribute("clientes", dao.getClientes());
                uri = "cliente.jsp";

                break;
        }

        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);

    }
}
