<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Eliminarr Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <%@ include file="template/header.jsp" %> 

    <div class="container my-5">
        <h2 class="mb-4">¿Estás seguro de que deseas eliminar al usuario ${usuario.nombre}?</h2>

        <div class="alert alert-warning" role="alert">
            <strong>Advertencia:</strong> Esta acción no se puede deshacer.
        </div>

        <!-- Detalles del usuario -->
        <ul class="list-group mb-4">
            <li class="list-group-item"><strong>Nombre:</strong> ${usuario.nombre}</li>
            <li class="list-group-item"><strong>DNI:</strong> ${usuario.dni}</li>
            <li class="list-group-item"><strong>Teléfono:</strong> ${usuario.telefono}</li>
            <li class="list-group-item"><strong>Email:</strong> ${usuario.email}</li>
            <li class="list-group-item"><strong>Rol:</strong> ${usuario.rol}</li>
        </ul>

        <!-- Formulario de confirmación -->
        <form action="UsuarioController" method="post">
            <input type="hidden" name="action" value="eliminar" />
            <input type="hidden" name="dni" value="${usuario.dni}" />

            <!-- Botón para confirmar la eliminación -->
            <button type="submit" class="btn btn-danger">Eliminar Usuario</button>
        </form>

        <br/>
        <a href="UsuarioController?action=listar" class="btn btn-secondary">Cancelar</a>
    </div>

    <%@ include file="template/footer.jsp" %>
</body>
</html>