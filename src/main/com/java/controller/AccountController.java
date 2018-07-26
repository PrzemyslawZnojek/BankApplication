package main.com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.com.java.entity.Account;
import main.com.java.entity.Customer;
import main.com.java.service.domain.interfaces.AccountService;

@Controller
@RequestMapping("/customer")
public class AccountController {
	
	//need to inject customerService
	@Autowired
	private AccountService accountService;

	@GetMapping("/showFormForAddAccount")
	public String showFormForAddAccount(Model theModel){
		
		//create model attribute to find
		Account theAccount = new Account();
		
		theModel.addAttribute("account", theAccount);
		
		return "account-form";
	}
	
	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute("account") Account theAccount) {
		
		// save the customer using our service
		accountService.addAccount(theAccount);
		
		return "redirect:/customer/list";
	}
}
