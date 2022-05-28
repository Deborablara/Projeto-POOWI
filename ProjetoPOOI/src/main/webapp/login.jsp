
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
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: 'Montserrat', sans-serif;
            box-sizing: border-box;
        }

        body {
            background: #1D2540;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .flex-container {
            max-width: 40vw;
            max-height: 100vh;
            background-color: #FAF7FD;
            border-radius: 1%;
            margin: 0 auto;
            margin-top: 5%;
            padding: 3rem 6rem;
            font-size: 14px;
        }

        .flex-container h1 {
            text-align: center;
            margin-top: 0.5rem;
        }

        .flex-container .flex-input-50 {
            width: 50%;
            float: left;
            padding: 1rem;
        }

        .flex-container .flex-input-100 {
            width: 100%;
            float: left;
            padding: 1rem;
        }

        .flex-container .flex-input-50 input,
        .flex-input-100 input,
        .flex-input-100 textarea {
            margin-top: 5px;
            border: none;
            background-color: rgba(128, 128, 128, 0.089);
            padding: 0.8rem;
            border-radius: 2%;
            width: 100%;
            font-size: 15px;
        }

        .flex-container .flex-input-100 button {
            padding: 1rem;
            width: 100%;
            background: #8DBF21;
            border-radius: 5%;
            border: none;
            color: #ffffff;
            font-weight: bold;
            float: right;
        }

    </style>
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