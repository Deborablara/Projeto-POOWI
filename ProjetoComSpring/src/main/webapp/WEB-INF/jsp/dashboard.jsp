<%--
  Created by IntelliJ IDEA.
  User: debora
  Date: 27/05/2022
  Time: 20:45
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
    <link href="<c:url value="/css/dashboard.css"/>" rel="stylesheet" type="text/css">
    <title>Página inicial</title>
</head>
<body>
<section id="navbar">
    <jsp:include page="../components/menu.jsp"></jsp:include>
</section>
<main class="dashboard">
    <section id="content">
        <h2>Bem-vindo(a), <span>${usuario_logado.nome}</span></h2>
        <h3>ACESSE O MENU LATERAL</h3>
    </section>
</main>
</body>
</html>
