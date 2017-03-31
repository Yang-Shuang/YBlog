package com.yang.encode;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Created by YangShuang
 * on 2017/3/31.
 */
@SuppressWarnings("Since15")
public class RSAUtils {


    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqIKoUJtx5e7A7L2cSqFjTDKLv3+LpksenJmz7zqCPUWJnJXaQoCLyIUyrcjxzX9gtp6/4BUmDzcf0UozIBoDm/G/Z9K6UDgZep6YkKqQ8B2oVcFrn08wRocziRPPvDtSdWe+spnP2g1gzxaHBNogVIkk6D1cRedNryd+fdPObrQIDAQAB";
    private static String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKogqhQm3Hl7sDsvZxKoWNMMou/f4umSx6cmbPvOoI9RYmcldpCgIvIhTKtyPHNf2C2nr/gFSYPNx/RSjMgGgOb8b9n0rpQOBl6npiQqpDwHahVwWufTzBGhzOJE8+8O1J1Z76ymc/aDWDPFocE2iBUiSToPVxF502vJ359085utAgMBAAECgYBFZsPbKqtAR6vxyPmkS9bIadxCPLQFkuItluhYpMctEAczir3ea+U1n032lsiATHYU0dZgOE/wG89ZJR/XLYgBh6DVMa83awXUQ6FcIoMtE0g4d8LFphlKNf95axzJlbjIDUR22GUCF0uu/GzLM5vPUarU8F4012mEi8+Yk+3xAQJBAOX2laterwFo90qK2Uopkvhvklcujpp2d3y+yQYIb6Tf0+288xFL0A1F+yXPvtgK87gx7fkR67k7i9PrNzJZ+W0CQQC9Y8MPgEdPdXPCcBD5q1E36SxfoI/fU1vG6YG8uGpfKUDAaM5aaauktyVxkDq59oxPcOh9nd8n9Po7kSTwiwNBAkB1v5YRYnDvouSEiaYLIFB93vsqos8n7iLuf+4Epcssu+MTJx26rHwCX+PiD4ajrq/uj7pPP0rY1NGbGCRyJrndAkAAviBosicVb695hrj6Uaqq3nY3FckaphgJCqdglxSLtPy1BHQytJFgvvsdm+QvEIFyWk3/GBxk6rgEfcg4TUNBAkBdOcuLh2nhCc6aubtAWWSfTtl24FNMcoOiAJCptddsHI2nTEabjsdZ9wVz7eXqz2p9zJJ8CGSO0TboYKmQkt+B";

    public static void getkey(){
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024);
            KeyPair keyPair = generator.generateKeyPair();
            byte[] publick = keyPair.getPublic().getEncoded();
            byte[] privatek = keyPair.getPrivate().getEncoded();
            String publicKe = Base64.getEncoder().encodeToString(publick);
            String privateKe = Base64.getEncoder().encodeToString(privatek);
            System.out.print(publicKe);
            System.out.print("\n---------\n");
            System.out.print(privateKe);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String encryptData(String str){
        byte[] data = Base64.getDecoder().decode(str);

        byte[] key = Base64.getDecoder().decode(publicKey);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec spec = new X509EncodedKeySpec(key);
            PublicKey pk = keyFactory.generatePublic(spec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(cipher.ENCRYPT_MODE,pk);
            int  input = data.length;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return "";
    }
}
