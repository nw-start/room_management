<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Listar Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="template/header.jsp" %>
    
    <div class="container my-4">
        <h2 class="mb-4">Lista de Usuarios</h2>

        <!-- Mensaje de error -->
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </c:if>

        <!-- Tabla de usuarios -->
        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead class="table-light">
                    <tr>
                        <th>Nombre</th>
                        <th>DNI</th>
                        <th>Teléfono</th>
                        <th>Email</th>
                        <th>Rol</th>
                        <th>Contraseña</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterar sobre la lista de usuarios -->
                    <c:forEach var="usuario" items="${usuarios}">
                        <tr>
                            <td>${usuario.nombre}</td>
                            <td>${usuario.dni}</td>
                            <td>${usuario.telefono}</td>
                            <td>${usuario.email}</td>
                            <td>${usuario.rol}</td>
                            <td>${usuario.contraseña}</td>
                            <td>
                        		<a href="UsuarioController?action=editar&dni=${usuario.dni}">Editar</a> |
                        		<a href="UsuarioController?action=eliminar&dni=${usuario.dni}">Eliminar</a>
                    		</td>
                        </tr>
                    </c:forEach>
                </tbody>
                
                <br/>
    			<a href="UsuarioController?action=registrar">Registrar Nuevo Usuario</a>
            </table>
        </div>
    </div>
    
    <%@ include file="template/footer.jsp" %>

</body>
</html>