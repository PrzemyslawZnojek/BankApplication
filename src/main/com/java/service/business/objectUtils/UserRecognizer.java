package main.com.java.service.business.objectUtils;

import main.com.java.entity.Account;
import main.com.java.service.domain.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserRecognizer {

    private AccountService accountService;

    @Autowired
    public UserRecognizer(AccountService accountService) {
        this.accountService = accountService;
    }

    protected String getAccountNumber(){
        Account account = accountService.getAccountByUsername(getAuthenticatedPrincipalUsername());
        return account.getAccountNumber();
    }

    public String getAuthenticatedPrincipalUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
