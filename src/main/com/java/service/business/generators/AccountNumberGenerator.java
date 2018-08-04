package main.com.java.service.business.generators;

import main.com.java.service.domain.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class AccountNumberGenerator {

    @Autowired
    AccountService accountService;

    @Transactional
    public String generateAccountNumber(){
        String potentialAccountNumber = generatePotentialAccountNumber();
        if(checkIsAccountNumberIsFree(potentialAccountNumber)){
           return potentialAccountNumber;
        }else{
            while(checkIsAccountNumberIsFree(potentialAccountNumber)){
                potentialAccountNumber = generatePotentialAccountNumber();
            }
            return generatePotentialAccountNumber();
        }
    }

    private String generatePotentialAccountNumber(){
        String checksum = generateChecksum();
        String bankNumber = "12853321";
        String clientNumber = generateClientNumber();
        String accountNumber = "";

        StringBuilder stringBuilder = new StringBuilder(accountNumber);
        stringBuilder.append(checksum).append(bankNumber).append(clientNumber);


        return stringBuilder.toString();
    };


    private  boolean checkIsAccountNumberIsFree(String potentialAccountNumber){
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

    private String generateClientNumber(){
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
