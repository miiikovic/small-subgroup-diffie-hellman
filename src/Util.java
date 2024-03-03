import java.math.BigInteger;
import java.security.MessageDigest;

public class Util {

    // Conversion from hex to byte array
    public static byte[] hexStringToByteArray(String s) {

        int len = s.length();
        byte[] data = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;

    }

    // Conversion to byte array
    public static byte[] toByteArray(BigInteger i) {
        byte[] iArr = i.toByteArray();
        if (iArr[0] == 0) {
            byte[] tmp = new byte[iArr.length - 1];
            System.arraycopy(iArr, 1, tmp, 0, tmp.length);
            iArr = tmp;
        }
        return iArr;
    }

    // SHA-256 Algorithm
    public static byte[] sha_256(BigInteger kInt) throws Exception {
        MessageDigest testDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = testDigest.digest(Util.toByteArray(kInt));
        return hashBytes;
    }


    // Attack
    public static String breaker(BigInteger p, BigInteger g, byte[] iv, byte[] cipherText, String pattern)
                                                                                        throws Exception {
        // Starting from 1
        BigInteger i = BigInteger.valueOf(1);

        // Brute-Force
        while(true) {

            MessageDigest testDigest = MessageDigest.getInstance("SHA-256");
            byte[] testAesKeyArr = sha_256(g.modPow(i, p));
            String testPlaintext = AES_Service.decrypt(cipherText, testAesKeyArr, iv);

            if (testPlaintext.contains(pattern)) {
                return testPlaintext;
            }

            i = i.add(BigInteger.ONE);
        }

    }
}
