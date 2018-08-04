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
import main.com.java.service.domain.implementation.AccountServiceImpl;
import main.com.java.service.domain.interfaces.AccountService;

@Controller
@RequestMapping("/customer")
public class AccountController {
	
	@Autowired
	private AccountService accountService = new AccountServiceImpl();

	@GetMapping("/showFormForAddAccount")
	public String showFormForAddAccount(Model theModel){

		Account theAccount = new Account();
		
		theModel.addAttribute("account", theAccount);
		
		return "account-form";
	}
	
	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute("account") Account theAccount) {
		AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator();
		theAccount.setAccountNumber(accountNumberGenerator.generateAccountNumber());

		accountService.addAccount(theAccount);
		return "redirect:/customer/list";
	}
}
