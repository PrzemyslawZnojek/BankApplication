package main.com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.com.java.dao.AccountDAO;
import main.com.java.entity.Account;
import main.com.java.entity.Customer;
import main.com.java.service.AccountService;
import main.com.java.service.CustomerService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	//need to inject customerService
	@Autowired
	private AccountService accountService;

	
	@GetMapping("/showFormForAddAccount")
	public String showFormForUpdate(Model theModel){
		
		//create model attribute to find
		Account theAccount = new Account();
		
		theModel.addAttribute("account", theAccount);
		
		return "account-form";
		
	}
}
