package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ProdutoDAO;
import br.ufsm.csi.model.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("produto")
public class ProdutoController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        String produto = req.getParameter("descricao");
        Produto p = new Produto(produto);
        ProdutoDAO dao = new ProdutoDAO();
        String uri = " ";
        String retorno = "";

        switch (opcao){

            case "cadastrar":
                retorno = dao.Cadastrar(p);
                req.setAttribute("retorno", retorno);

                uri = "produto.jsp";

                break;

            case "listar":
                ArrayList<Produto> produtos = dao.getProdutos();
                req.setAttribute("produtos", produtos);
                uri = ("listarProdutos.jsp");

                break;
        }
        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);



    }
}
