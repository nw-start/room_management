package utils;

import java.sql.Connection;

public class ConexionBDTest {

	public static void main(String[] args) {
        Connection conn = null;
        
        try {
            // Intentar obtener la conexión utilizando el método getConnexion de ConexionBD
            conn = ConexionBD.getConnexion();
            
            // Verificar si la conexión es exitosa
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (Exception e) {
            // Manejo de errores si ocurre algún problema al conectar
            System.out.println("Error en la conexión: " + e.getMessage());
        } finally {
            // Cerrar la conexión si es que está abierta
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Conexión cerrada.");
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
