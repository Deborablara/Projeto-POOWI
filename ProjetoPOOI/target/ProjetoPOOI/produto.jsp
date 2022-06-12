<%--
  Created by IntelliJ IDEA.
  User: debora
  Date: 28/05/2022
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>

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
    <link rel="stylesheet" href="resources/CSS/style.css">
    <title>Produtos</title>
</head>
<body>
<section id="navbar">
    <div>
        <h1><span>Logo</span>Empresa</h1>
        <div id="menu">
            <p>MENU</p>
            <ul>
                <li><a href="dashboard?opcao=pedidos">Pedidos</a></li>
                <li><a href="dashboard?opcao=clientes">Clientes</a></li>
                <li><a href="dashboard?opcao=veiculos">Veículos</a></li>
                <li><a href="dashboard?opcao=funcionarios">Funcionários</a></li>
                <li><a href="dashboard?opcao=produtos" class="active">Produtos</a></li>
            </ul>
        </div>
    </div >
    <div id="footer">
        <img src="./assets/door.png" alt="ícone de usuário branco">
        <a href="dashboard?opcao=logout"><p>Sair</p></a>
    </div>
    </div>
</section>
<main>
    <section id="content">

        <c:if test="${retorno == 'OK'}">
            <p style="color:green; text-align: right; margin-bottom: 15px;">Produto Cadastrado com sucesso!</p>
        </c:if>
        <c:if test="${retorno == 'erro'}">
            <p style="color:red; text-align: right; margin-bottom: 15px;">Falha ao executar esta ação!</p>
        </c:if>

        <div class="divbutton">
            <h2>Produtos</h2>
            <a onclick="openPopup()" >Cadastrar novo produto</a>
        </div>

        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Opção</th>
            </tr>
            <c:forEach var="produtos" items="${produtos}">
                <tr>
                    <td>${produtos.id}</td>
                    <td>${produtos.nome}</td>
                    <td><a href="produto?opcao=excluir&&id=${p.id}"><img src="./assets/edit.png"  class="icon-edit" alt="lápis preto">Editar </a></td>
                </tr>
            </c:forEach>
        </table>


        <div class="popup">
            <div class="conteudo">
                <img src="./assets/x.png" alt="ícone de fechar" onclick="closePopup()" />
                <h3>Novo produto</h3>
                <form action="produto?opcao=cadastrar" method="post">
                    <div>
                        <label for="descricao">Descrição</label>
                    </div>
                    <div>
                        <input
                                type="text"
                                name="descricao"
                                placeholder="Nome do produto"
                        />

                    </div>
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
