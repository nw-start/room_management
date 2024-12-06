package security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SecurityFilter {}

/*
@WebFilter("/*")
public class SecurityFilter implements Filter {


	  
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    
    

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Obtener el rol del usuario de la sesión
        String rol = (String) httpRequest.getSession().getAttribute("rol");

      
        // Obtener la URI solicitada
        String requestURI = httpRequest.getRequestURI();

        // Si no hay rol en la sesión y la página solicitada no es la de login, redirigir al login
        if ( !requestURI.contains("LoginController") && !requestURI.contains("registroUsuario.jsp")) {
            httpResponse.sendRedirect("index.jsp"); // Redirigir al login si no está autenticado
            return;
        }

        // Si el rol es null (usuario no autenticado) y se está intentando acceder a una página protegida, redirigir
        if (requestURI.startsWith("/admin") && !"admin".equals(rol)) {
            httpResponse.sendRedirect("accesoDenegado.jsp");
            return;
        }

        if (requestURI.startsWith("/usuario") && !"usuario".equals(rol) && !"admin".equals(rol)) {
            httpResponse.sendRedirect("accesoDenegado.jsp");
            return;
        }

        // Si el acceso es permitido, continuar con la cadena de filtros
        chain.doFilter(request, response);
        
    }
    

    @Override
    public void destroy() {}
    
}

*/
