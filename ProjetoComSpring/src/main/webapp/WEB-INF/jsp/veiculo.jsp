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
    <title>Veículos</title>
</head>
<body>
<section id="navbar">
    <jsp:include page="../components/menu.jsp"></jsp:include>
</section>
<main>
    <section class="content">

        <c:if test="${retorno == 'OK'}">
            <p style="color:green; text-align: right; margin-bottom: 15px;">Veículo cadastrado com sucesso!</p>
        </c:if>
        <c:if test="${retorno == 'erro'}">
            <p style="color:red; text-align: right; margin-bottom: 15px;">Falha ao executar esta ação!</p>
        </c:if>

        <div class="divbutton">
            <h2>Veículos</h2>
            <a onclick="openPopup()" >Cadastrar novo veículo</a>
        </div>

        <table>
            <tr>
                <th>Id</th>
                <th>Placa</th>
            </tr>
            <c:forEach var="veiculos" items="${veiculos}">
                <c:if test="${veiculos.isAtivo}">
                    <tr>
                        <td>${veiculos.id}</td>
                        <td>${veiculos.placa}</td>
                        <td style="text-align: center"><a href="/app/veiculo/verVeiculo?placa=${veiculos.placa}"><img src="<c:url value="/assets/edit.png"/>"  class="icon-edit" alt="lápis preto">Editar </a></td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>


        <div class="popup">
            <div class="conteudo">
                <img src="./assets/x.png" alt="ícone de fechar" onclick="closePopup()" />
                <h3>Novo produto</h3>
                <form action="/app/veiculo/cadastrar" method="post">
                    <div>
                        <label for="placa">Placa</label>
                    </div>
                    <div>
                        <input
                                type="text"
                                name="placa"
                                placeholder="Placa do veículo"
                                required
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