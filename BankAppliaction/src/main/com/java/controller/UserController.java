package main.com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/panel")
	public String showPanel(Model theModel){

		return "indexUser";
	}
	
	public String showFormForMakeTransfer(Model theModel){

		return "transfer-form";
	}

}
