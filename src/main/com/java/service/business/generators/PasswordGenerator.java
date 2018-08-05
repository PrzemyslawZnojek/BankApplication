package main.com.java.service.business.generators;

import java.security.SecureRandom;

public class PasswordGenerator {

    private final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "0123456789";
    private final String ALL_CHARS = LETTERS + NUMBERS;

    private static SecureRandom random = new SecureRandom();

    public String generatePassword(String dictionary){
        String password = "";
        int lenghtOfPassword = 8;
        for (int i = 0; i < lenghtOfPassword; i++) {
            int indexOfCharInDictionary = random.nextInt(dictionary.length());
            password += dictionary.charAt(indexOfCharInDictionary);
        }
        return password;
    }
}
