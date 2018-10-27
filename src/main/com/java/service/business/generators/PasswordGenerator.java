package main.com.java.service.business.generators;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PasswordGenerator {

    private final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "0123456789";
    private final String ALL_CHARS = LETTERS + NUMBERS;
    String password = "";

    private static SecureRandom random = new SecureRandom();

    public String returnPasswordWithEncryption(){
        String unencryptedPassword = generatePassword();
        StringBuilder buildEncryptedPassword = new StringBuilder(unencryptedPassword);
        buildEncryptedPassword.insert(0,"{noop}");
        return buildEncryptedPassword.toString();
    }

    public String generatePassword(){
        this.password = "";
        int lenghtOfPassword = 8;
        for (int i = 0; i < lenghtOfPassword; i++) {
            int indexOfCharInDictionary = random.nextInt(ALL_CHARS.length());
            password += ALL_CHARS.charAt(indexOfCharInDictionary);
        }
        System.out.println(password);
        return password;
    }

    public String getPassword() {
        return password;
    }

}
