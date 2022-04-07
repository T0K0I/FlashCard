package Utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class AuthenticationHandler {

    public static String HashPass(String pass){
        return BCrypt.withDefaults().hashToString(12, pass.toCharArray());
    }

    public static boolean checkHash(String pass, String hash){
        BCrypt.Result result = BCrypt.verifyer().verify(pass.toCharArray(), hash);
        return result.verified;
    }
}
