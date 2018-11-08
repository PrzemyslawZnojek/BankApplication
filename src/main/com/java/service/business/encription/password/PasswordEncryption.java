package main.com.java.service.business.encription.password;

import org.springframework.stereotype.Service;

@Service
public class PasswordEncryption {

    public static String returnPasswordWithEncryption(String password){
        String encryptedPassword = Password.hashPassword(password);
        StringBuilder buildEncryptedPassword = new StringBuilder(encryptedPassword);
        buildEncryptedPassword.insert(0,"{bcrypt}");
        return buildEncryptedPassword.toString();
    }


}
