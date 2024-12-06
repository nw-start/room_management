package service;

import dao.UsuarioDAO;
import model.Usuario;
import utils.PasswordUtils;

import java.sql.SQLException;
import java.util.List;

public class UsuarioService {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	// Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() throws SQLException {
        return usuarioDAO.obtenerTodosLosUsuarios();
    }

 // Registrar un nuevo usuario
    public void registrarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.registrarUsuario(usuario);
    }

    // Obtener un usuario por su DNI
    public Usuario obtenerUsuarioPorDni(String dni) throws SQLException {
        return usuarioDAO.obtenerUsuarioPorDni(dni);
    }
    
 // Actualizar la información de un usuario
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.actualizarUsuario(usuario);
    }

 // Método para eliminar un usuario
    public void eliminarUsuario(String dni) throws SQLException {
        usuarioDAO.eliminarUsuario(dni);
    }
    
    
    public Usuario autenticarUsuario(String usuario, String contrasena) throws SQLException {
        Usuario user = usuarioDAO.obtenerUsuarioPorUsuario(usuario);
        
        
        if (user != null && PasswordUtils.verifyPassword(contrasena, user.getContrasena())) {
            return user; // Retorna el usuario si la contraseña coincide
        }
        
        return null;
    }
    

}
