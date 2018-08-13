package main.com.java.controller;

import main.com.java.entity.Account;
import main.com.java.entity.Customer;
import main.com.java.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.com.java.entity.RegisterObject;
import main.com.java.service.business.generators.AccountNumberGenerator;
import main.com.java.service.business.generators.PasswordGenerator;
import main.com.java.service.domain.interfaces.AccountService;
import main.com.java.service.domain.interfaces.CustomerService;
import main.com.java.service.domain.interfaces.UsersService;

@Controller
@RequestMapping("/customer")
public class AccountController {

	private AccountService accountService;
    private CustomerService customerService;
    private UsersService usersService;
    private PasswordGenerator passwordGenerator;
    private AccountNumberGenerator accountNumberGenerator;

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService, UsersService usersService, PasswordGenerator passwordGenerator, AccountNumberGenerator accountNumberGenerator) {
        this.accountService = accountService;
        this.customerService = customerService;
        this.usersService = usersService;
        this.passwordGenerator = passwordGenerator;
        this.accountNumberGenerator = accountNumberGenerator;
    }


	@GetMapping("/showFormForAddAccount")
	public String showFormForAddAccount(Model theModel){
		RegisterObject registerObject = new RegisterObject(new Account(), new Customer(), new Users());
		theModel.addAttribute("registerObject", registerObject);
		
		return "account-form";
	}
	
	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute("registerObject") RegisterObject registerObject) {
		registerObject.getAccount().setAccountNumber(accountNumberGenerator.generateAccountNumber());
		registerObject.getUsers().setPassword(passwordGenerator.generatePassword());
		registerObject.getCustomer().setIdOfAccount(registerObject.getAccount().getAccountID());
		registerObject.getUsers().setUsername(registerObject.getAccount().getUsername());
		registerObject.getUsers().setEnabled(true);
        accountService.addAccount(registerObject.getAccount());
		usersService.addUser(registerObject.getUsers());
        System.out.print("Maybe here 1");
		customerService.addCustomer(registerObject.getCustomer());
		System.out.print("Maybe here 2");

		return "redirect:/customer/list";
	}
}
