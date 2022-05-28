<%--
  Created by IntelliJ IDEA.
  User: debora
  Date: 28/05/2022
  Time: 14:21
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
            cursor: pointer;
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
            width: 100%;
            color: #ffffff;
            transition: color 0.3s;
            transition: border 0.3s;
        }

        #menu ul li a:hover, #menu ul li a.active{
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
            padding: 2em;
        }

        main h2{
            color: var(--azul);
            font-size: 2em;
            margin-left: 1.4em;
        }

        main section#content{
            width: 100%;
            margin: 0 auto;
            padding-top: 5rem;
            display: flex;

        }

        .card {
            width: 30%;
            height: 35vh;
            padding: 2rem 2rem;
            box-shadow: 0px 0px 12px rgba(0, 0, 0, 0.2);
            border-bottom: 0.25rem solid var(--verde);
            border-radius: 0.25rem 0.25rem 0 0;
            text-align: center;
            margin-left: 3em;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-between;

        }

        .card a{
            background: var(--verde);
            color: var(--azul);
            width: 90%;
            font-size: 1em;
            padding: 0.8rem;
            border-radius: 3px;
            transition: background 0.3s;

        }

        .card a:hover{
            background: var(--azul);
            color: var(--verde);
        }

        .card img{
            width:18%;
        }

        .popup{
            background: rgba(0, 0, 0, 0.5);
            width: 100vw;
            height: 100vh;
            position: fixed;
            top: 0;
            left: 0;
            display: none;
        }

        .active{
            display: flex;
        }

        .popup .conteudo{
            width: 35vw;
            height: 60vh;
            padding:2rem;
            background: var(--branco);
            border-radius: 3px;
            margin: 5rem auto;
        }

        .popup .conteudo img{
            width:3%;
            float: right;
        }

        .popup .conteudo h3{
            margin-top:30px;
            font-size: 1.5em;
            text-align:center;
        }

        .popup .conteudo form{
            width: 100%;
            margin-top: 2rem;
        }

        .popup .conteudo form input{
            width: 100%;
            background:#00000017;
            padding: 5px;
            margin-top: 5px;
            border: none;
            border-radius: 3px;
            font-size: 12px;
        }

        .button{
            display: flex;
            justify-content:flex-end;
            margin-top: 10rem;
        }

        .popup .conteudo form button{
            background: var(--azul);
            color: var(--branco);
            padding: 0.5rem;
            width: 50%;
            border: none;
            border-radius: 3px;
        }

        /*tabelas*/

        table {
            border-collapse: collapse;
            width: 70%;
            margin:2rem auto;
            font-size: 14px;
        }

        td, th {
            border: 1px solid var(--branco);
            text-align: left;
            padding: 8px;
        }


        tr:nth-child(even) {
            background-color: #1d254017;
        }


        .icon-edit{
            width: 16px;
            margin-right: 10px;
        }
    </style>
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
                <li><a href="dashboard?opcao=produtos">Produtos</a></li>
            </ul>
        </div>
    </div >
    <div id="footer">
        <img src="./assets/door.png" alt="ícone de usuário branco">
        <a href=""><p>Sair</p></a>
    </div>
    </div>
</section>
<main>
    <h2>Produtos</h2>
    <section id="content">
        <div class="card">
            <img  src="./assets/plus.png" alt="simbolo de mais verde">
            <a onclick="openPopup()" >Cadastrar novo produto</a>
        </div>
        <div class="popup">
            <div class="conteudo">
                <img src="./assets/x.png" alt="ícone de fechar" onclick="closePopup()" />
                <h3>Novo produto</h3>
                <form action="" method="post">
                    <div>
                        <label for="descricao">Descrição</label>
                    </div>
                    <div>
                        <input
                                type="text"
                                name="descricao"
                                id="descricao"
                                placeholder="Nome do produto"
                        />
                    </div>
                    <div class="button">
                        <button type="submit">Cadastrar</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="card">
            <img src="./assets/list.png" alt="simbolo de mais verde">
            <a>Listar Produtos</a>
        </div>
    </section>
</main>
<script src="./script.js"></script>
</body>
</html>
