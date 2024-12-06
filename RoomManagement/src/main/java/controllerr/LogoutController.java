package controllerr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidar la sesi�n actual
        request.getSession().invalidate();

        // Redirigir al usuario a la p�gina de inicio de sesi�n (index.jsp o donde desees)
        response.sendRedirect("index.jsp");
    }
}
