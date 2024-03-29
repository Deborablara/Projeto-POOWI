<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="pt-br">
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
    <title>Pedidos</title>
</head>
<body>
<section id="navbar">
    <jsp:include page="../components/menu.jsp"></jsp:include>
</section>
<main>
    <section class="content">

        <c:if test="${retorno == 'OK'}">
            <p style="color:green; text-align: right; margin-bottom: 15px;">Pedido cadastrado com sucesso!</p>
        </c:if>
        <c:if test="${retorno == 'erro'}">
            <p style="color:red; text-align: right; margin-bottom: 15px;">Falha ao executar esta ação!</p>
        </c:if>

        <div class="divbutton">
            <h2>Pedidos</h2>
            <c:if test="${usuario_logado.permissao.id == 1}">
                <a onclick="openPopup()" style="text-align: center">Novo Pedido</a>
            </c:if>
        </div>

        <div class="selecionar">
            <p>Filtrar por:</p></br>
            <div>
                <input type="radio" name="filtro">
                <label>Prazo de Entrega</label>
            </div>
            <div>
                <input type="radio" name="filtro">
                <label>Pendentes</label>
            </div>
            <div>
                <input type="radio" name="filtro">
                <label>Em produção</label>
            </div>
            <div>
                <input type="radio" name="filtro">
                <label>Produzido</label>
            </div>
            <div>
                <input type="radio" name="filtro">
                <label>Carregado</label>
            </div>
            <div>
                <input type="radio" name="filtro">
                <label>Número da placa</label>
            </div>
        </div>

        <table>

            <tr>
                <th>Nº Pedido</th>
                <th>Produto</th>
                <th>Quantidade</th>
                <th>Cliente</th>
                <th>Data do pedido</th>
                <th>Data de entrega</th>
                <th>Placa</th>
                <th>Status</th>
            </tr>


            <c:forEach var="pedidos" items="${pedidos}">
                <c:if test="${pedidos.isAtivo}">
                    <tr>
                        <td>${pedidos.id}</td>
                        <td>${pedidos.produto.nome}</td>
                        <td>${pedidos.quantidade}t</td>
                        <td>${pedidos.cliente.nome}</td>
                        <td>${pedidos.dataPedido}</td>
                        <td>${pedidos.dataEntrega}</td>
                        <td>${pedidos.veiculo.placa}</td>
                        <td>${pedidos.status.nome}</td>
                        <td><a href="/app/pedido/verPedidos?id=${pedidos.id}"><img src="<c:url value="/assets/edit.png"/>"  class="icon-edit" alt="lápis preto">Editar </a></td>
                    </tr>
                </c:if>
            </c:forEach>

        </table>


        <div class="popup">
            <div class="conteudo">
                <img src="./assets/x.png" alt="ícone de fechar" onclick="closePopup()" />
                <h3>Novo pedido</h3>
                <form action="/app/pedido/cadastrar" method="post">
                    <div>
                        <label>Produto:</label>
                        <select name="produto">
                            <c:forEach var="produto" items="${produtos}">
                                <c:if test="${produto.isAtivo}">
                                    <option value="${produto.id}">${produto.nome}</option>
                                </c:if>
                            </c:forEach>

                        </select>
                    </div>
                    <div class="margin-top">
                        <label for="quantidade">Quantidade (t):</label>
                        <input type="number" name="quantidade" step=0.01>
                    </div>
                    <div class="margin-top">
                        <label>Cliente:</label>
                        <select name="cliente">
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
                        <input type="date" name="dataEntrega">
                    </div>
                    <input type="hidden" name="status" value="1">
                    <div class="button">
                        <button type="submit">Cadastrar</button>
                    </div>

                </form>
            </div>
        </div>

    </section>
</main>
<script src="./script.js"></script>
</body>
<script>
    const popup = document.querySelector('.popup')

    function openPopup() {
        popup.classList.add('active')
    }
    function closePopup() {
        popup.classList.remove('active')
    }
</script>
</html>
</html>