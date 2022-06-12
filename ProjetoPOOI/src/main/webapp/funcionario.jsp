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
    <title>Funcionários</title>
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
                <li><a href="dashboard?opcao=funcionarios" class="active">Funcionários</a></li>
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
    <section class="content">

        <c:if test="${retorno == 'OK'}">
            <p style="color:green; text-align: right; margin-bottom: 15px;">Funcionário cadastrado com sucesso!</p>
        </c:if>
        <c:if test="${retorno == 'erro'}">
            <p style="color:red; text-align: right; margin-bottom: 15px;">Falha ao executar esta ação!</p>
        </c:if>

        <div class="divbutton">
            <h2>Funcionários</h2>
            <a onclick="openPopup()">Novo funcionário</a>
        </div>

        <table>
            <tr>
                <th>Id</th>
                <th>Nome de Usuario</th>
                <th>Permissão</th>
            </tr>
            <c:forEach var="usuarios" items="${usuarios}">
                <tr>
                    <td>${usuarios.id}</td>
                    <td>${usuarios.nome}</td>
                    <td>${usuarios.permissao.nomePermissao}</td>
                    <td><a href="veiculo?opcao=excluir&&id=${veiculos.placa}"><img src="./assets/edit.png"  class="icon-edit" alt="lápis preto">Editar </a></td>
                </tr>
            </c:forEach>
        </table>


        <div class="popup">
            <div class="conteudo">
                <img src="./assets/x.png" alt="ícone de fechar" onclick="closePopup()" />
                <h3>Novo produto</h3>
                <form action="usuario?opcao=cadastrar" method="post">
                    <div>
                        <label for="nome">Nome de Usuario</label>
                    </div>
                    <div>
                        <input
                                type="text"
                                name="nome"
                                placeholder="Usuário"
                        />

                    </div>
                    <div class="margin-top">
                        <label for="senha">Senha</label>
                    </div>
                    <div>
                        <input
                                type="password"
                                name="senha"
                        />

                    </div>
                    <div class="margin-top">
                        <label>Permissao</label>
                        <select name="permissao">
                            <option value="2">Colaborador</option>
                            <option value="1">Administrador</option>
                        </select>
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
