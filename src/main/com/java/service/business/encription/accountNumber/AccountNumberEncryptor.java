package main.com.java.service.business.encription.accountNumber;

import java.security.MessageDigest;

public class AccountNumberEncryptor {

    public static String getSha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashInBytes = digest.digest(base.getBytes("UTF-8"));
            return bytesToHexConverter(hashInBytes);
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    private static String bytesToHexConverter(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

}
