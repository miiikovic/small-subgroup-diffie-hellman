import java.math.BigInteger;



public class Main {
    public static void main(String[] args) throws Exception {
        BigInteger p = new BigInteger ("834687362676124296171787459907592363617022661417466816913771577752792106973" +
                                                            "13710568346710317111988418803802766965465360916451839321840366" +
                                                            "37786283416968451775171284786649292417659034814572941778786667" +
                                                            "10687989967560212010026097376460203351423444322178418805396492" +
                                                            "66882136298235658187342889786961520512000360449", 10); // prime p
        BigInteger g = new BigInteger ("757012663528175667450357504771427728714905066473653626717874426634787167356" +
                                                            "21201704671858158138478363496577203357843817783818146811118" +
                                                            "354744296459497892017488743552700656184100188887311893320774" +
                                                            "606412157515875514172282317794831914090498483087615146045992" +
                                                            "09833302216423972239376417823662651575332690758118786", 10); // generator in Zp*
        BigInteger ivInt = new BigInteger ("EE864E00C8DB6C22879C9484C31278CC", 16); // Public IV
        BigInteger cipherTextInt = new BigInteger("BC0F89B1B48C90D453335ABE2D142B712ED10F5F22D2CFAFC56052C4E461828C79EDC343C2D01F68999A1633F47BC320",16); // Public hash of the message
        String pattern = "but"; // A pattern we suppose exists in the hidden message

        byte[] iv = Util.toByteArray(ivInt);
        byte[] cipherText = Util.toByteArray(cipherTextInt);

        String plainText = Util.breaker(p, g, iv, cipherText, pattern);

        System.out.println(plainText);

    }


}
