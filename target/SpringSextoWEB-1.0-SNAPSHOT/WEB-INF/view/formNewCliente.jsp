<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" 
          href="${pageContext.request.contextPath}/resources/css/estilos.css" />
    <title>Adicion de nuevo Cliente</title>
  </head>
  <body class="container">
    <h1>Adicion de Cliente nuevo</h1>
    
    <form:form action="creaCliente" modelAttribute="modCliente" method="POST" >
      <form:hidden path="cliId" />
      <table>
        <tr>
          <td>Nombre:</td>
          <td> <form:input path="cliNombre" /> </td>
        </tr>
        <tr>
          <td>Paterno:</td>
          <td> <form:input path="cliPaterno" /> </td>
        </tr>
        <tr>
          <td>Correo Electronico:</td>
          <td> <form:input path="cliEmail" /> </td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" value="Registrar" />
          </td>
        </tr>
      </table>
      
    </form:form>
    
  </body>
</html>
