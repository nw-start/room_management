package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    private UsuarioService usuarioService = new UsuarioService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        
       /*

        try {
            Usuario user = usuarioService.autenticarUsuario(usuario, contrasena);
            if (user != null) {
                // Almacenar el usuario y su rol en la sesi�n
                request.getSession().setAttribute("usuario", user);
                request.getSession().setAttribute("rol", user.getRol());

                // Imprimir los atributos de la sesi�n para depuraci�n
                System.out.println("Usuario: " + user.getNombre());
                System.out.println("Rol: " + user.getRol());

                // Redirigir a la p�gina principal despu�s de iniciar sesi�n
                response.sendRedirect("home.jsp");
            } else {
                request.setAttribute("error", "Credenciales incorrectas.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error en el servidor.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        */
        // Redirigir a la p�gina principal despu�s de iniciar sesi�n
        response.sendRedirect("home.jsp");
    }
    
    
}

