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
    <title>Produto</title>
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
                <li><a href="dashboard?opcao=veiculos" >Veículos</a></li>
                <li><a href="dashboard?opcao=funcionarios">Funcionários</a></li>
                <li><a href="dashboard?opcao=produtos"  class="active">Produtos</a></li>
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
    <section class="content">
        <div class="divbutton">
            <h2>Produto</h2>
        </div>

        <div class="form-visualizar">
            <form action="produto?opcao=editar" method="post">
                <div>
                    <label for="nome">Nome do produto</label>
                </div>
                <div>
                    <input
                            type="text"
                            name="nome"
                            value="${produto.nome}"
                    />
                    <input
                            type="hidden"
                            name="id"
                            value="${produto.id}"
                    />

            </form>
            <div class="botoes">
                <button type="submit" class="editar">Editar</button>
                <a href="produto?opcao=excluir&&id=${produto.id}" class="excluir">Excluir</a>
                <a href="produto?opcao=cancelar" class="cancelar">Cancelar</a>
            </div>
        </div>



    </section>
</main>
</body>
</html>
