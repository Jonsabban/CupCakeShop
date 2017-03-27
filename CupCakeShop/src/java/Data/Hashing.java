package Data;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Hashing {

    public String hashPassword(String password) {
        
        
        
        return password;
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}
