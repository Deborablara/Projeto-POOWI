<%--
  Created by IntelliJ IDEA.
  User: debora
  Date: 16/08/2022
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<div>
  <h1><span>Logo</span>Empresa</h1>
  <div id="menu">
    <p>MENU</p>
    <ul>
      <li><a href="/app/pedido">Pedidos</a></li>
      <c:if test="${usuario_logado.permissao.id == 1}">
        <li><a href="/app/cliente">Cliente</a></li>
        <li><a href="/app/veiculo">Veículos</a></li>
        <li><a href="/app/usuario">Funcionários</a></li>
        <li><a href="/app/produto">Produtos</a></li>
      </c:if>
    </ul>
  </div>
</div >
<div id="footer">
  <img src="<c:url value="/assets/door.png"/>" alt="ícone de usuário branco">
  <a href="/app/login/logout"><p>Sair</p></a>
</div>
</div>
