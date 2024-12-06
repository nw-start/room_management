<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Editar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <%@ include file="template/header.jsp" %> 

    <div class="container my-5">
        <h2 class="mb-4">Editar Usuario</h2>

        <form action="UsuarioController" method="post">
            <input type="hidden" name="action" value="editar" />
            <input type="hidden" name="dni" value="${usuario.dni}" />

            <!-- Nombre -->
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" id="nombre" name="nombre" value="${usuario.nombre}" class="form-control" required />
            </div>

            <!-- Teléfono -->
            <div class="mb-3">
                <label for="telefono" class="form-label">Teléfono:</label>
                <input type="text" id="telefono" name="telefono" value="${usuario.telefono}" class="form-control" required />
            </div>

            <!-- Email -->
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" id="email" name="email" value="${usuario.email}" class="form-control" required />
            </div>

            <!-- Rol -->
            <div class="mb-3">
                <label for="rol" class="form-label">Rol:</label>
                <select id="rol" name="rol" class="form-select" required>
                    <option value="admin" <c:if test="${usuario.rol == 'admin'}">selected</c:if>>Administrador</option>
                    <option value="cliente" <c:if test="${usuario.rol == 'cliente'}">selected</c:if>>Cliente</option>
                </select>
            </div>

            <!-- Contraseña -->
            <div class="mb-3">
                <label for="contraseña" class="form-label">Contraseña:</label>
                <input type="password" id="contraseña" name="contraseña" value="${usuario.contraseña}" class="form-control" required />
            </div>

            <!-- Botón de submit -->
            <button type="submit" class="btn btn-primary">Actualizar Usuario</button>

        </form>

        <br/>
        <a href="UsuarioController?action=listar" class="btn btn-secondary">Volver a la lista de usuarios</a>
    </div>

    <%@ include file="template/footer.jsp" %>
</body>
</html>