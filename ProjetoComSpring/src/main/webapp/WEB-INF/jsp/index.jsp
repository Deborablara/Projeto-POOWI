
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;500&display=swap"
            rel="stylesheet"
    />
    <link href="<c:url value="/css/login.css"/>" rel="stylesheet" type="text/css">
    <title>Login</title>
</head>

<body>
<div class="flex-container">
    <h1>Login</h1>
    <form action="login" method="post">
        <div class="flex-input-100">
            <div>
                <label for="nome"> Usuário </label>
            </div>
            <div>
                <input type="text" name="nome" id="nome" />
            </div>
        </div>
        <div class="flex-input-100">
            <div>
                <label for="senha"> Senha </label>
            </div>
            <div>
                <input type="password" name="senha" id="senha" />
            </div>
        </div>

        <div class="flex-input-100">
            <button type="submit">ENTRAR</button>
        </div>
    </form>
</div>
</body>
</html>