package main.com.java.service.business.generators;

import main.com.java.service.business.encription.Password;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PasswordGenerator {

    private final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "0123456789";
    private final String ALL_CHARS = LETTERS + NUMBERS;

    private static SecureRandom random = new SecureRandom();

    public String returnPasswordWithEncryption(){
        String encryptedPassword = Password.hashPassword(generatePassword());
        StringBuilder buildEncryptedPassword = new StringBuilder(encryptedPassword);
        buildEncryptedPassword.insert(0,"{bcrypt}");
        return buildEncryptedPassword.toString();
    }

    public String generatePassword(){
        String password = "";
        int lenghtOfPassword = 8;
        for (int i = 0; i < lenghtOfPassword; i++) {
            int indexOfCharInDictionary = random.nextInt(ALL_CHARS.length());
            password += ALL_CHARS.charAt(indexOfCharInDictionary);
            System.out.println(password);
        }
        return password;
    }
}
