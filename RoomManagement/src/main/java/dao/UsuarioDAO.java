package dao;

import model.Usuario;
import utils.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        try {
            connection = utils.ConexionBD.getConnexion();  // Usamos tu clase de conexión a la base de datos
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Registrar un nuevo usuario
    public void registrarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nombre, dni, telefono, email, rol, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getDni());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getRol());
            ps.setString(6, usuario.getContrasena());
            ps.executeUpdate();
        }
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("rol"),
                        rs.getString("contrasena")
                );
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    // Obtener un usuario por su DNI
    public Usuario obtenerUsuarioPorDni(String dni) throws SQLException {
        String query = "SELECT * FROM usuario WHERE dni = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getString("nombre"),
                            rs.getString("dni"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            rs.getString("rol"),
                            rs.getString("contrasena")
                    );
                }
            }
        }
        return null;
    }

    // Actualizar la información de un usuario
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE usuario SET nombre = ?, telefono = ?, email = ?, rol = ?, contrasena = ? WHERE dni = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getTelefono());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getRol());
            ps.setString(5, usuario.getContrasena());
            ps.setString(6, usuario.getDni());
            ps.executeUpdate();
        }
    }

    // Método para eliminar un usuario por su DNI
    public void eliminarUsuario(String dni) throws SQLException {
        String sql = "DELETE FROM usuario WHERE dni = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, dni); // Establecemos el DNI que se quiere eliminar
            preparedStatement.executeUpdate(); // Ejecutamos la consulta
        }
    }
    
    
    public Usuario obtenerUsuarioPorUsuario(String usuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE email = ? OR dni = ?";
        try (Connection conn = ConexionBD.getConnexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, usuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapearUsuario(rs); // Método para mapear el resultado a un objeto Usuario
            }
        }
        return null;
    }
    
  

    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        return new Usuario(
            rs.getString("nombre"),
            rs.getString("dni"),
            rs.getString("telefono"),
            rs.getString("email"),
            rs.getString("rol"),
            rs.getString("contrasena")
        );
    }
   


}