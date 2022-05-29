package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ProdutoDAO;
import br.ufsm.csi.dao.VeiculoDAO;
import br.ufsm.csi.model.Produto;
import br.ufsm.csi.model.Veiculo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("veiculo")
public class VeiculoController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        String placa = req.getParameter("placa");
        Veiculo v = new Veiculo(placa);
        VeiculoDAO dao = new VeiculoDAO();
        String uri = " ";
        String retorno = "";

        switch (opcao){
            case "cadastrar":

                retorno = dao.Cadastrar(v);
                req.setAttribute("retorno", retorno);
                req.setAttribute("veiculos", dao.getVeiculos());
                System.out.println(dao.getVeiculos());
                uri = "veiculo.jsp";

                break;
        }
        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);
    }
}
