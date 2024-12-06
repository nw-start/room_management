package utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordUtils {
	
	
    public static String hashPassword(String contrasena) {
        return BCrypt.withDefaults().hashToString(12, contrasena.toCharArray());
    }
    
    public static boolean verifyPassword(String contrasena, String hashedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(contrasena.toCharArray(), hashedPassword);
        return result.verified;
    }
}