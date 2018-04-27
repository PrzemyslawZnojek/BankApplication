package main.com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel){
		
		return "list-customers";
	}

}
