package main.com.java.service.business.generators;

import main.com.java.service.domain.implementation.AccountServiceImpl;
import main.com.java.service.domain.interfaces.AccountService;

import java.util.List;
import java.util.Random;

public class AccountNumberGenerator {

    private static String generateAccountNumber(){
        String potentialAccountNumber = generatePotentialAccountNumber();
        if(checkIsAccountNumberIsFree(potentialAccountNumber)){
            return potentialAccountNumber;
        }else{
            while(checkIsAccountNumberIsFree(potentialAccountNumber)){
                return generatePotentialAccountNumber();
            }
        }
    }

    private static String generatePotentialAccountNumber(){
        String checksum = generateChecksum();
        String bankNumber = "12853321";
        String clientNumber = generateClientNumber();
        String accountNumber = "";

        StringBuilder stringBuilder = new StringBuilder(accountNumber);
        stringBuilder.append(checksum).append(bankNumber).append(clientNumber);

        return accountNumber;
    };

    private static boolean checkIsAccountNumberIsFree(String potentialAccountNumber){
        AccountService accountService = new AccountServiceImpl();
        List<String> occupiedAccountNumberList = accountService.getAccountNumberList();
        for (String occupiedAccountNumber : occupiedAccountNumberList) {
            if(potentialAccountNumber.equals(occupiedAccountNumber)){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;

    };

    private static String generateChecksum(){
        Random random = new Random();
        String checksum = "";
        StringBuilder stringBuilder = new StringBuilder(checksum);

        for (int i =0; i<2; i++){
            stringBuilder.append(random.nextInt(10));
        }
        checksum = stringBuilder.toString();
        return checksum;
    };

    private static String generateClientNumber(){
        Random random = new Random();
        String clientNumber = "";
        StringBuilder stringBuilder = new StringBuilder(clientNumber);

        for (int i =0; i<16; i++){
            stringBuilder.append(random.nextInt(10));
        }
        clientNumber = stringBuilder.toString();
        return clientNumber;
    }

}
