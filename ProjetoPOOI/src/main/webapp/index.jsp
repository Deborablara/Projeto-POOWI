
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="resources/CSS/login.css">
    <title>Login</title>
</head>

<body>
<div class="flex-container">
    <h1>Login</h1>
    <form action="login" method="post">
        <div class="flex-input-100">
            <div>
                <label for="usuario"> Usuário </label>
            </div>
            <div>
                <input type="text" name="usuario"  />
            </div>
        </div>
        <div class="flex-input-100">
            <div>
                <label for="senha"> Senha </label>
            </div>
            <div>
                <input type="password" name="senha"  />
            </div>
        </div>

        <div class="flex-input-100">
            <button type="submit">ENTRAR</button>
        </div>
    </form>
</div>
</body>
</html>