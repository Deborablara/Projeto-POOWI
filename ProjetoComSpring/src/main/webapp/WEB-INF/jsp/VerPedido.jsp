<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,500;0,700;0,800;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
    <title>Pedido</title>
</head>
<body>
<section id="navbar">
    <jsp:include page="../components/menu.jsp"></jsp:include>
</section>
<main>
    <section class="content">

        <div class="divbutton">
            <h2>Pedido</h2>
        </div>

        <div class="form-visualizar">
            <form action="/app/pedido/editar?id=${pedido.id}" method="post">
                <div>
                    <label>Produto:</label>
                    <select name="produto">
                        <option value="${pedido.produto.id}">${pedido.produto.nome}</option>
                        <c:forEach var="produto" items="${produtos}">
                            <c:if test="${produto.isAtivo}">
                                <option value="${produto.id}">${produto.nome}</option>
                            </c:if>
                        </c:forEach>

                    </select>
                </div>
                <div class="margin-top">
                    <label for="quantidade">Quantidade (t):</label>
                    <input type="number" name="quantidade" step=0.01 value="${pedido.quantidade}">
                </div>
                <div class="margin-top">
                    <label>Cliente:</label>
                    <select name="cliente">
                        <option value="${pedido.cliente.id}">${pedido.cliente.nome}</option>
                        <c:forEach var="cliente" items="${clientes}">
                            <c:if test="${cliente.isAtivo}">
                                <option value="${cliente.id}">${cliente.nome}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="margin-top">
                    <label>Veículo:</label>
                    <select name="veiculo">
                        <option value="${pedido.veiculo.id}">${pedido.veiculo.placa}</option>
                        <c:forEach var="veiculo" items="${veiculos}">
                            <c:if test="${veiculo.isAtivo}">
                                <option value="${veiculo.id}">${veiculo.placa}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="margin-top">
                    <label for="dataEntrega">Previsão de entrega:</label>
                </div>
                <div>
                    <input type="date" name="dataEntrega" value="${pedido.dataEntrega}">
                    <input type="hidden" name="dataPedido" value="${pedido.dataPedido}">
                </div>
                <div>
                    <label>Status do pedido:</label>
                    <select name="status">
                        <option value="1">Pendente</option>
                        <option value="2">Em produção</option>
                        <option value="3">Aguardando carregamento</option>
                        <option value="4">Carregado</option>
                        <option value="5">Entregue</option>
                    </select>
                </div>
                <div class="botoes">
                    <button type="submit" class="editar">Editar</button>
                    <a href="/app/pedido/excluir?id=${pedido.id}" class="excluir">Excluir</a>
                    <a href="/app/pedido" class="cancelar">Cancelar</a>
                </div>

            </form>

        </div>
    </section>
</main>
</body>
</html>
</html>
