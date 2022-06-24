package br.ufsm.csi.controller;

import br.ufsm.csi.dao.PedidoDAO;
import br.ufsm.csi.dao.VeiculoDAO;
import br.ufsm.csi.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@WebServlet("pedido")
public class PedidoController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        PedidoDAO dao = new PedidoDAO();
        String retorno;
        String uri = " ";

        switch (opcao){
            case "cadastrar":
                int  produto = Integer.parseInt(req.getParameter("produto"));
                Produto p = new Produto(produto);

                int  cliente = Integer.parseInt(req.getParameter("cliente"));
                Cliente c = new Cliente(cliente);

                int veiculo = Integer.parseInt(req.getParameter("veiculo"));
                Veiculo v = new Veiculo(veiculo);

                Date dataEntrega = Date.valueOf(req.getParameter("dataEntrega"));
//                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//                java.sql.Date Dataformatada = java.sql.Date.valueOf(format.format(dataEntrega));

                Float quantidade = Float.parseFloat(req.getParameter("quantidade"));


                int id_status = Integer.parseInt(req.getParameter("status"));
                Status status = new Status(id_status);

                System.out.println(produto);
                System.out.println(cliente);
                System.out.println(dataEntrega);
                System.out.println(quantidade);
                System.out.println(status);
                System.out.println(veiculo);

                Pedido pedido = new Pedido(p, c,dataEntrega, quantidade, status, v);
                retorno = dao.Cadastrar(pedido);
                req.setAttribute("pedidos", new PedidoDAO().getPedidos());

                uri = "WEB-INF/Pedido.jsp";

                break;


        }

        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);

    }
}
