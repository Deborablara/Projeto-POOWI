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
        VeiculoDAO dao = new VeiculoDAO();
        String uri = " ";
        String retorno = "";

        switch (opcao){
            case "cadastrar":
                String placa = req.getParameter("placa");
                Veiculo v = new Veiculo(placa);

                retorno = dao.Cadastrar(v);
                req.setAttribute("retorno", retorno);
                req.setAttribute("veiculos", dao.getVeiculos());
                uri = "WEB-INF/veiculo.jsp";

                break;
            case "ver":
                String buscarplaca = req.getParameter("placa");
                Veiculo veiculo =  dao.GetVeiculo(buscarplaca);
                req.setAttribute("veiculo", veiculo);

                uri = "WEB-INF/VerVeiculo.jsp";
                break;
            case "editar":
                int id = Integer.parseInt(req.getParameter("id"));
                String placaEdit = req.getParameter("placa");
                Veiculo veiculoEdit = new Veiculo(placaEdit, id);

                retorno = dao.Editar(veiculoEdit);

                if(retorno.equals("OK")){
                    req.setAttribute("veiculos", new VeiculoDAO().getVeiculos());
                    uri = "WEB-INF/veiculo.jsp";
                    break;
                }else{
                    req.setAttribute("retorno", retorno);
                    uri = "WEB-INF/VerVeiculo.jsp";
                    break;
                }
            case "excluir":
                int idVeiculo = Integer.parseInt(req.getParameter("id"));
                retorno = dao.Excluir(idVeiculo);
                if(retorno.equals("OK")){
                    req.setAttribute("veiculos", new VeiculoDAO().getVeiculos());
                    uri="WEB-INF/veiculo.jsp";
                }
                break;
            case "cancelar":
                req.setAttribute("veiculos", new VeiculoDAO().getVeiculos());
                uri="WEB-INF/veiculo.jsp";
                break;
            default:
                break;
        }
        RequestDispatcher rd = req.getRequestDispatcher(uri);
        rd.forward(req, resp);
    }
}
