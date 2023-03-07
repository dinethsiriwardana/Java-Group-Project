package com.tecmis.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Security {



    public String encryption(String encryption) throws Exception{
        byte[] key = "tecmisjavagroup2".getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedDataByte = cipher.doFinal(encryption.getBytes("UTF-8"));
        String encryptedData = Base64.getEncoder().encodeToString(encryptedDataByte);

        return encryptedData;
    }
    private String decryption(String encryptedData) throws Exception {
        byte[] key = "tecmisjavagroup2".getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] encryptedDataByte = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedDataByte = cipher.doFinal(encryptedDataByte);
        String decryptedData = new String(decryptedDataByte, "UTF-8");

        return decryptedData;
    }
}

