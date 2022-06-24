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
        ProdutoDAO dao = new ProdutoDAO();
        String uri = " ";
        String retorno = "";

        switch (opcao){

            case "cadastrar":
                String nome = req.getParameter("descricao");
                Produto produto = new Produto(nome);
                retorno = dao.Cadastrar(produto);
                req.setAttribute("retorno", retorno);
                req.setAttribute("produtos", dao.getProdutos());

                uri = "WEB-INF/produto.jsp";

                break;

            case "listar":
                ArrayList<Produto> produtos = dao.getProdutos();
                req.setAttribute("produtos", produtos);
                uri = ("WEB-INF/listarProdutos.jsp");

                break;

            case "ver":
                int id = Integer.parseInt(req.getParameter("id"));
                Produto p = dao.getProduto(id);
                req.setAttribute("produto", p);
                uri = ("WEB-INF/VerProduto.jsp");
                break;

            case "editar":
                String nomeProduto = req.getParameter("nome");
                int idProduto = Integer.parseInt(req.getParameter("id"));
                Produto produtoEditar = new Produto(nomeProduto, idProduto);
                retorno = dao.Editar(produtoEditar);

                if(retorno.equals("OK")){
                    req.setAttribute("produtos", dao.getProdutos());
                    uri = "WEB-INF/produto.jsp";
                }else{
                    req.setAttribute("retorno", retorno);
                    uri = "WEB-INF/VerVeiculo.jsp";
                }
                break;

            case "cancelar":
                req.setAttribute("produtos", dao.getProdutos());
                uri = "WEB-INF/produto.jsp";
                break;

            case "excluir":
                int idEditar = Integer.parseInt(req.getParameter("id"));
                dao.Excluir(idEditar);

                req.setAttribute("produtos", dao.getProdutos());
                uri = "WEB-INF/produto.jsp";

                break;


            default:
                uri = "WEB-INF/produto.jsp";

                break;

        }
        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);



    }
}
