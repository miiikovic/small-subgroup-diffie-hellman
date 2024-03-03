import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES_Service {
    public static byte[] encrypt(byte[] plaintext, byte[] key, byte[] IV) throws Exception {

        // Cipher instance
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");

        // Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");

        // Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(IV));

        // Perform Encryption
        byte[] cipherText = cipher.doFinal(plaintext);

        return cipherText;
    }


    public static String decrypt (byte[] cipherText, byte[] key, byte[] IV) throws Exception {

        // Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");

        // Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");

        // Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(IV));

        // Perform Decryption
        byte[] decryptedText = cipher.doFinal(cipherText);

        return new String(decryptedText);

    }
}
