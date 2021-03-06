package main.com.java.service.business.objectUtils;

import main.com.java.entity.RegisterObject;
import main.com.java.service.business.encription.accountNumber.AESAlgorithmUtils;
import main.com.java.service.business.encription.accountNumber.AccountNumberEncryptor;
import main.com.java.service.business.generators.AccountNumberGenerator;
import main.com.java.service.business.encription.password.PasswordEncryption;
import main.com.java.service.domain.interfaces.AccountService;
import main.com.java.service.domain.interfaces.AuthoritiesService;
import main.com.java.service.domain.interfaces.CustomerService;
import main.com.java.service.domain.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterObjectService {

    private AccountService accountService;
    private CustomerService customerService;
    private UsersService usersService;
    private AuthoritiesService authoritiesService;
    private PasswordEncryption passwordEncryption;
    private AccountNumberGenerator accountNumberGenerator;
    private RegisterObject registerObject;

    @Autowired
    public RegisterObjectService(AccountService accountService, CustomerService customerService, UsersService usersService, AuthoritiesService authoritiesService, PasswordEncryption passwordEncryption, AccountNumberGenerator accountNumberGenerator) {
        this.accountService = accountService;
        this.customerService = customerService;
        this.usersService = usersService;
        this.authoritiesService = authoritiesService;
        this.passwordEncryption = passwordEncryption;
        this.accountNumberGenerator = accountNumberGenerator;
    }

    public RegisterObjectService(RegisterObjectBuilder registerObjectBuilder) {
        this.accountService = registerObjectBuilder.accountService;
        this.customerService = registerObjectBuilder.customerService;
        this.usersService = registerObjectBuilder.usersService;
        this.authoritiesService = registerObjectBuilder.authoritiesService;
        this.passwordEncryption = registerObjectBuilder.passwordEncryption;
        this.accountNumberGenerator = registerObjectBuilder.accountNumberGenerator;
        this.registerObject = registerObjectBuilder.registerObject;
    }

    public void insertIntoThreeTablesByOneSubmit() {
        addAccount();
        addUser();
        addCustomer();
        addAuthorities();
    }

    private void addAccount() {
        updateAccountObject();
        accountService.addAccount(registerObject.getAccount());
    }

    private void addUser() {
        updateUserObject();
        usersService.addUser(registerObject.getUsers());
    }

    private void addCustomer() {
        updateCustomerObject();
        customerService.addCustomer(registerObject.getCustomer());
    }

    private void addAuthorities() {
        updateAuthorities();
        authoritiesService.addAuthorities(registerObject.getAuthorities());
    }

    private void updateAccountObject() {
        String generatedAccountNumber = accountNumberGenerator.generateAccountNumber();
        registerObject.getAccount().setAccountNumber(
                AESAlgorithmUtils.encryptWithAES(registerObject.getUsers().getPassword(), generatedAccountNumber)
        );
    }

    private void updateCustomerObject() {
        registerObject.getCustomer().setIdOfAccount(registerObject.getAccount().getAccountID());
    }

    private void updateUserObject() {
        registerObject.getUsers().setPassword(
                PasswordEncryption.returnPasswordWithEncryption(registerObject.getUsers().getPassword())
        );
        registerObject.getUsers().setUsername(registerObject.getAccount().getUsername());
    }

    private void updateAuthorities() {
        registerObject.getAuthorities().setUsername(registerObject.getAccount().getUsername());
    }

    public static class RegisterObjectBuilder {

        private AccountService accountService;
        private CustomerService customerService;
        private UsersService usersService;
        private AuthoritiesService authoritiesService;
        private PasswordEncryption passwordEncryption;
        private AccountNumberGenerator accountNumberGenerator;
        private RegisterObject registerObject;

        public RegisterObjectBuilder() {
        }

        ;

        public RegisterObjectBuilder accountService(AccountService accountService) {
            this.accountService = accountService;
            return this;
        }

        public RegisterObjectBuilder customerService(CustomerService customerService) {
            this.customerService = customerService;
            return this;
        }

        public RegisterObjectBuilder usersService(UsersService usersService) {
            this.usersService = usersService;
            return this;
        }

        public RegisterObjectBuilder authoritiesService(AuthoritiesService authoritiesService) {
            this.authoritiesService = authoritiesService;
            return this;
        }

        public RegisterObjectBuilder passwordGenerator(PasswordEncryption passwordEncryption) {
            this.passwordEncryption = passwordEncryption;
            return this;
        }

        public RegisterObjectBuilder accountNumberGenerator(AccountNumberGenerator accountNumberGenerator) {
            this.accountNumberGenerator = accountNumberGenerator;
            return this;
        }

        public RegisterObjectBuilder registerObject(RegisterObject registerObject) {
            this.registerObject = registerObject;
            return this;
        }

        public RegisterObjectService build() {
            return new RegisterObjectService(this);
        }

    }
}
