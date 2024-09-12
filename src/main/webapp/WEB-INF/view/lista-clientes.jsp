<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" 
          href="${pageContext.request.contextPath}/resources/css/estilos.css" />
    <title>Proyecto de Clientes</title>
  </head>
  <body class="container">
    <h1>Hola Mundo!</h1>
    <p>Hemos llegado a la futura Lista de Clientes</p>
    <table>
      <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Email</th>
        <th>Modificar</th>
      </tr>
      <c:forEach var="cliTemporal" items="${modCliente}">
        <c:url var="linkActual" value="formModifCliente" >
          <c:param name="clienteId" value="${cliTemporal.cliId}" />
        </c:url>
        <tr>
          <td>${cliTemporal.cliNombre}</td>
          <td>${cliTemporal.cliPaterno}</td>
          <td>${cliTemporal.cliEmail}</td>
          <td>
            <a href="${linkActual}" ><input type="button" value="Modificar" /></a>
          </td>
        </tr>
      </c:forEach>
    </table>

    <p>
      <input type="button" value="Nuevo Usuario" 
             onclick="window.location.href='formAdiCli'; return false;"  />
    </p>
    
  </body>
</html>
