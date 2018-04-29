package main.com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import main.com.java.daoimpl.AccountDAOImpl;
import main.com.java.entity.Account;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountDAOImpl account;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel){
		
		List<Account> accountsList = account.getAccounts();
		
		theModel.addAttribute("accounts", accountsList);
		
		return "list-customers";
	}

}
