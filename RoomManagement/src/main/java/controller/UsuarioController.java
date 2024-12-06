package controller;

import model.Usuario;
import service.UsuarioService;
import utils.PasswordUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UsuarioController extends HttpServlet {

    private UsuarioService usuarioService;

    public UsuarioController() {
        usuarioService = new UsuarioService();  // Instanciamos el servicio
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("listar".equals(action)) {
                listarUsuarios(request, response);
            } else if ("editar".equals(action)) {
                editarUsuario(request, response);
            } else if ("eliminar".equals(action)) {
                eliminarUsuario(request, response);
            } else if ("registrar".equals(action)) {
                // Redirigir a la página de registro de usuario
                RequestDispatcher dispatcher = request.getRequestDispatcher("registroUsuario.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
        	if ("registrar".equals(action)) {
        	    registrarUsuario(request, response);
            } else if ("editar".equals(action)) {
                actualizarUsuario(request, response);
            } else if ("eliminar".equals(action)) {
                eliminarUsuario(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        request.setAttribute("usuario", usuarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarUsuarios.jsp");
        dispatcher.forward(request, response);
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String rol = request.getParameter("rol");
        String contrasena = request.getParameter("contrasena");

        // Verificar si la contraseña es nula
        if (contrasena == null || contrasena.trim().isEmpty()) {
            request.setAttribute("error", "La contraseña no puede estar vacía.");
            request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
            return;
        }

        // Encriptar la contraseña
        
        String hashedPassword = PasswordUtils.hashPassword(contrasena);

        //Usuario usuario = new Usuario(nombre, dni, telefono, email, rol, hashedPassword);
        Usuario usuario = new Usuario(nombre, dni, telefono, email, rol, contrasena);
        usuarioService.registrarUsuario(usuario);

        response.sendRedirect("UsuarioController?action=listar");
    }


    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String dni = request.getParameter("dni");
        Usuario usuario = usuarioService.obtenerUsuarioPorDni(dni);

        request.setAttribute("usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String rol = request.getParameter("rol");
        String contrasena = request.getParameter("contrasena");

        Usuario usuario = new Usuario(nombre, dni, telefono, email, rol, contrasena);
        usuarioService.actualizarUsuario(usuario);

        response.sendRedirect("UsuarioController?action=listar");
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String rol = (String) request.getSession().getAttribute("rol");
        
        /*

        if (rol == null || !"admin".equals(rol)) {
            response.sendRedirect("accesoDenegado.jsp");
            return;  // No continuar con la operación si no es admin
        }
        */

        String dni = request.getParameter("dni");
        Usuario usuario = usuarioService.obtenerUsuarioPorDni(dni);

        if (usuario != null) {
            usuarioService.eliminarUsuario(dni); // Lógica de eliminación
            response.sendRedirect("listarUsuarios.jsp");
        } else {
            response.sendRedirect("UsuarioController?action=listar");
        }
    }


}
