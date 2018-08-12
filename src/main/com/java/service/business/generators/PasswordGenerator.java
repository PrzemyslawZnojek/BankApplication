package main.com.java.service.business.generators;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PasswordGenerator {

    private final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "0123456789";
    private final String ALL_CHARS = LETTERS + NUMBERS;

    private static SecureRandom random = new SecureRandom();

    public String generatePassword(){
        String password = "";
        int lenghtOfPassword = 8;
        for (int i = 0; i < lenghtOfPassword; i++) {
            int indexOfCharInDictionary = random.nextInt(ALL_CHARS.length());
            password += ALL_CHARS.charAt(indexOfCharInDictionary);
        }
        return password;
    }
}
