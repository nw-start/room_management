package utils;

import java.sql.Connection;

public class ConexionBDTest {

	public static void main(String[] args) {
        Connection conn = null;
        
        try {
            // Intentar obtener la conexi�n utilizando el m�todo getConnexion de ConexionBD
            conn = ConexionBD.getConnexion();
            
            // Verificar si la conexi�n es exitosa
            if (conn != null) {
                System.out.println("Conexi�n exitosa a la base de datos.");
            }
        } catch (Exception e) {
            // Manejo de errores si ocurre alg�n problema al conectar
            System.out.println("Error en la conexi�n: " + e.getMessage());
        } finally {
            // Cerrar la conexi�n si es que est� abierta
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Conexi�n cerrada.");
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexi�n: " + e.getMessage());
            }
        }
    }
}
