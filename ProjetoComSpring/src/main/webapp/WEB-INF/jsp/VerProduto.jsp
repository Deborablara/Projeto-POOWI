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
    <title>Produto</title>
</head>
<body>
<section id="navbar">
    <jsp:include page="../components/menu.jsp"></jsp:include>
</section>
<main>
    <section class="content">
        <div class="divbutton">
            <h2>Produto</h2>
        </div>

        <div class="form-visualizar">
            <form action="/app/produto/editar-produto" method="post">
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
                </div>
                <div class="botoes">
                    <button type="submit" class="editar">Editar</button>
                    <a href="/app/produto/excluir?id=${produto.id}" class="excluir">Excluir</a>
                    <a href="/app/produto" class="cancelar">Cancelar</a>
                </div>

            </form>

        </div>



    </section>
</main>
</body>
</html>
