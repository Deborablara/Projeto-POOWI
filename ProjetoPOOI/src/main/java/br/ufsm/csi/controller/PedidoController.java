package br.ufsm.csi.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("pedido")
public class PedidoController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        String uri = " ";

        switch (opcao){
            case "cadastrar":
                int  produto = Integer.parseInt(req.getParameter("produto"));
                int  cliente = Integer.parseInt(req.getParameter("cliente"));
                Date data = java.sql.Date.valueOf(req.getParameter("dataEntrega"));
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String Dataformatada = format.format(data);
                Float quantidade = Float.parseFloat(req.getParameter("quantidade"));

                System.out.println(produto);
                System.out.println(cliente);
                System.out.println(Dataformatada);
                System.out.println(quantidade);



                uri = "Pedido.jsp";

                break;


        }

        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);

    }
}
