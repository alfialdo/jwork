package alfialdo.jwork.source;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class yang digunakan untuk hashing text menjadi Md5
 * @author Muhammad Alfi A
 * @version Final Project - 20 june 2021
 */
public class Hash {
    public static String hashMd5(String password) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashPassword = no.toString(16);

            while (hashPassword.length() < 32) {
                hashPassword = "0" + hashPassword;
            }

            return hashPassword;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}
