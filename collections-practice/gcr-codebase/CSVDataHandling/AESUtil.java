import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {
    private static final String key = "1234567812345678"; 

    public static String encrypt(String data) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k = new SecretKeySpec(key.getBytes(), "AES");
        c.init(Cipher.ENCRYPT_MODE, k);
        return Base64.getEncoder().encodeToString(c.doFinal(data.getBytes()));
    }

    public static String decrypt(String enc) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k = new SecretKeySpec(key.getBytes(), "AES");
        c.init(Cipher.DECRYPT_MODE, k);
        return new String(c.doFinal(Base64.getDecoder().decode(enc)));
    }
}