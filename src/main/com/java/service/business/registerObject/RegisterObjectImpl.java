package main.com.java.service.business.registerObject;

import main.com.java.entity.RegisterObject;
import main.com.java.service.business.generators.AccountNumberGenerator;
import main.com.java.service.business.generators.PasswordGenerator;
import main.com.java.service.domain.interfaces.AccountService;
import main.com.java.service.domain.interfaces.AuthoritiesService;
import main.com.java.service.domain.interfaces.CustomerService;
import main.com.java.service.domain.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterObjectImpl {

    private AccountService accountService;
    private CustomerService customerService;
    private UsersService usersService;
    private AuthoritiesService authoritiesService;
    private PasswordGenerator passwordGenerator;
    private AccountNumberGenerator accountNumberGenerator;
    private RegisterObject registerObject;

    @Autowired
    public RegisterObjectImpl(AccountService accountService, CustomerService customerService, UsersService usersService, AuthoritiesService authoritiesService, PasswordGenerator passwordGenerator, AccountNumberGenerator accountNumberGenerator) {
        this.accountService = accountService;
        this.customerService = customerService;
        this.usersService = usersService;
        this.authoritiesService = authoritiesService;
        this.passwordGenerator = passwordGenerator;
        this.accountNumberGenerator = accountNumberGenerator;
    }

    public RegisterObjectImpl(AccountService accountService, CustomerService customerService, UsersService usersService, AuthoritiesService authoritiesService, PasswordGenerator passwordGenerator, AccountNumberGenerator accountNumberGenerator, RegisterObject registerObject) {
        this.accountService = accountService;
        this.customerService = customerService;
        this.usersService = usersService;
        this.authoritiesService = authoritiesService;
        this.passwordGenerator = passwordGenerator;
        this.accountNumberGenerator = accountNumberGenerator;
        this.registerObject = registerObject;
    }

    public void insertIntoThreeTablesByOneSubmit(){
        addAccount();
        addUser();
        addCustomer();
        addAuthorities();
    }

    private void addAccount(){
        updateAccountObject();
        accountService.addAccount(registerObject.getAccount());
    }

    private void addUser(){
        updateUserObject();
        usersService.addUser(registerObject.getUsers());
    }

    private void addCustomer(){
        updateCustomerObject();
        customerService.addCustomer(registerObject.getCustomer());
    }

    private void addAuthorities(){
        updateAuthorities();
        authoritiesService.addAuthorities(registerObject.getAuthorities());
    }

    private void updateAccountObject(){
        registerObject.getAccount().setAccountNumber(accountNumberGenerator.generateAccountNumber());
    }

    private void updateCustomerObject(){
        registerObject.getCustomer().setIdOfAccount(registerObject.getAccount().getAccountID());
    }

    private void updateUserObject(){
        registerObject.getUsers().setPassword(passwordGenerator.returnPasswordWithEncryption());
        registerObject.getUsers().setUsername(registerObject.getAccount().getUsername());
    }

    private void updateAuthorities(){
        registerObject.getAuthorities().setUsername(registerObject.getAccount().getUsername());
    }

    public abstract class RegisteObjectBuilder{

        private AccountService accountService;
        private CustomerService customerService;
        private UsersService usersService;
        private AuthoritiesService authoritiesService;
        private PasswordGenerator passwordGenerator;
        private AccountNumberGenerator accountNumberGenerator;
        private RegisterObject registerObject;


    }
}
