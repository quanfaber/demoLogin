package utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Huynh Pham Minh Quan
 * @email hpminhquan96@gmail.com
 */
public class EncrytedPasswordUtils {

    public static String encrytePassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    public static boolean checkPassword(String rawPassword, String passwordEndcode){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, passwordEndcode);
    }
}
