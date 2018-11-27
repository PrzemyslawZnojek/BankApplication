package main.com.java.service.business.encription.accountNumber;

public class KeyChecker {
    private static final int PROPERLY_KEY_LENGTH = 16;

    public static String checkTheKey(String password) {
        int passwordLength = password.length();
        if (passwordLength > PROPERLY_KEY_LENGTH) {
            return shortenThePassword(password);
        } else if (passwordLength < PROPERLY_KEY_LENGTH) {
            return lengthenThePassword(password);
        } else {
            return password;
        }
    }

    private static String shortenThePassword(String password) {
        return password.substring(0, 15);
    }

    private static String lengthenThePassword(String password) {
        return new StringBuffer().append(password).append(addNullChars(password)).toString();
    }

    public static String addNullChars(String password) {
        int lengthToGenerate = PROPERLY_KEY_LENGTH - password.length();
        String stringToAdd = "0";
        while (lengthToGenerate > 1) {
            stringToAdd = new StringBuilder().append(stringToAdd).append("0").toString();
            lengthToGenerate--;
        }
        System.out.println(stringToAdd);
        return stringToAdd;
    }
}
