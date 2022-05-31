<%--
  Created by IntelliJ IDEA.
  User: debora
  Date: 27/05/2022
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
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
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,500;0,700;0,800;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />
    <style>
        :root{
            --azul: #1D2540;
            --branco: #FFFFFF;
            --verde: #8DBF21;
        }

        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
            color: #000000;
        }

        a {
            text-decoration: none;
        }

        h1{
            color: var(--branco);
        }


        img {
            width: 100%;
            height: auto;
        }

        ul {
            display: inline;
            list-style: none;
        }

        body{
            display: flex;
        }

        /********************** NAVBAR ***********************/

        section#navbar{
            width: 18vw;
            height: 100vh;
            background: var(--azul);
            padding-top: 2em;
            display: flex;
            justify-content: space-between;
            flex-direction: column;
            box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.395);
            position: fixed;
        }

        section#navbar h1{
            font-size: 30px;
            font-weight: 700;
            text-align: center;
        }

        section#navbar h1 span{
            color: var(--verde);
        }

        section#navbar #menu{
            width: 100%;
            padding: 2em;
        }

        section#navbar #menu p{
            font-weight: 300;
            text-align:center;
            color: var(--branco);
        }

        #menu ul li {
            margin-top: 2em;
            text-align: left;
            width: 100%;
            list-style-type: none;

        }


        #menu ul li a{
            color: #ffffff;
        }

        #menu ul li a:hover{
            color: var(--verde);
            border-bottom: 2px solid var(--verde);
        }

        #footer{
            padding: 2em;
            display: flex;
            justify-content:center;
            align-items: center;
            flex-direction: column;
        }

        #footer img{
            width: 10%;
            margin: 0 auto;
        }

        #footer p{
            margin-top: 5px;
            font-weight: 500;
            font-size: 0.9em;
            text-align:center;
            color: var(--branco);
        }

        #footer p:hover{
            color: var(--verde);
        }




        /********************* MAIN *****************/

        main{
            width: 82vw;
            margin-left: 18vw;
            display: flex;
            justify-content: center;
        }

        main section#content{
            width: 100%;
            margin: 0 auto;
            padding-top: 5rem;
        }

        main section#content h2{
            font-size: 2em;
            color: var(--azul);
            text-align:center;
        }

        main section#content h2 span{
            color: var(--verde);
        }
        main section#content h3{
            color:var(--azul);
            font-weight: 300;
            text-align: center;
        }
    </style>
    <title>Página inicial</title>
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
                <li><a href="dashboard?opcao=produtos">Produtos</a></li>
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
        <h2>Bem-vindo(a), <span>Usuário</span></h2>
        <h3>ACESSE O MENU LATERAL</h3>
    </section>
</main>
</body>
</html>
