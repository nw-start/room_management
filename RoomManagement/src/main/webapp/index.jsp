<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio de Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container my-5 pt-5 pb-5">
        <h2 class="text-center mb-4">Inicio de Sesión</h2>
        <form action="LoginController" method="post">
            <!-- Campo para usuario (por ejemplo, DNI o email) -->
            <div class="mb-3">
                <label for="usuario" class="form-label">Usuario:</label>
                <input type="text" id="usuario" name="usuario" class="form-control" required>
            </div>
            <!-- Campo para contraseña -->
            <div class="mb-3">
                <label for="contrasena" class="form-label">Contraseña:</label>
                <input type="password" id="contraseña" name="contrasena" class="form-control" required>
            </div>
            <!-- Botón de inicio de sesión -->
            <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
        </form>
        <!-- Enlace para registrarse -->
        <p class="text-center mt-4">
            ¿No tienes una cuenta? <a href="UsuarioController?action=registrar" class="text-decoration-none">Regístrate aquí</a>
        </p>
    </div>

    <%@ include file="template/footer.jsp" %>
</body>

</html>