package main.com.java.controller;


import main.com.java.service.business.generators.AccountNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.com.java.entity.Account;
import main.com.java.service.domain.interfaces.AccountService;

@Controller
@RequestMapping("/customer")
public class AccountController {


	private AccountService accountService;
	private AccountNumberGenerator accountNumberGenerator;

	@Autowired
	public AccountController(AccountService accountService,AccountNumberGenerator accountNumberGenerator){
		this.accountService = accountService;
		this.accountNumberGenerator = accountNumberGenerator;
	}


	@GetMapping("/showFormForAddAccount")
	public String showFormForAddAccount(Model theModel){

		Account theAccount = new Account();
		
		theModel.addAttribute("account", theAccount);
		
		return "account-form";
	}
	
	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute("account") Account theAccount) {
		theAccount.setAccountNumber(accountNumberGenerator.generateAccountNumber());

		accountService.addAccount(theAccount);
		return "redirect:/customer/list";
	}
}
