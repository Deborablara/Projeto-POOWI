package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ClienteDAO;
import br.ufsm.csi.model.Cliente;

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
        ClienteDAO dao = new ClienteDAO();
        String uri = " ";
        String retorno = "";

        switch (opcao){
            case "cadastrar":
                String nome = req.getParameter("nome");
                Cliente c = new Cliente(nome);

                retorno = dao.Cadastrar(c);
                req.setAttribute("retorno", retorno);
                req.setAttribute("clientes", dao.getClientes());

                uri = "WEB-INF/cliente.jsp";

                break;



            case "ver":
                int idcliente = Integer.parseInt(req.getParameter("id"));
                Cliente cliente = dao.GetCliente(idcliente);
                req.setAttribute("cliente", cliente);

                uri = "WEB-INF/Vercliente.jsp";
                break;


            case "editar":

                String nomeCliente = req.getParameter("nome");
                int id = Integer.parseInt(req.getParameter("id"));
                Cliente clienteEdit = new Cliente(id, nomeCliente);
                retorno = dao.Editar(clienteEdit);

                if(retorno.equals("OK")){
                    req.setAttribute("clientes", dao.getClientes());
                    uri = "WEB-INF/cliente.jsp";

                }else{
                    req.setAttribute("retorno", retorno);
                    uri = "WEB-INF/VerVeiculo.jsp";

                }
                break;


            case "cancelar":
                req.setAttribute("clientes", dao.getClientes());
                uri = "WEB-INF/cliente.jsp";
                break;


            case "excluir":
                int idExcluir = Integer.parseInt(req.getParameter("id"));
                retorno = dao.Excluir(idExcluir);
                if(retorno.equals("OK")){
                    req.setAttribute("clientes", dao.getClientes());
                    uri="WEB-INF/cliente.jsp";
                }
                break;

            default:
                uri="WEB-INF/cliente.jsp";
                break;
        }

        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);

    }
}
