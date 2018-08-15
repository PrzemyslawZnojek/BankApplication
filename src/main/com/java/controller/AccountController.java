package main.com.java.controller;

import main.com.java.entity.*;
import main.com.java.service.business.registerObject.RegisterObjectImpl;
import main.com.java.service.domain.interfaces.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.com.java.service.business.generators.AccountNumberGenerator;
import main.com.java.service.business.generators.PasswordGenerator;
import main.com.java.service.domain.interfaces.AccountService;
import main.com.java.service.domain.interfaces.CustomerService;
import main.com.java.service.domain.interfaces.UsersService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class AccountController {

	private AccountService accountService;
    private CustomerService customerService;
    private UsersService usersService;
    private PasswordGenerator passwordGenerator;
    private AccountNumberGenerator accountNumberGenerator;
    private AuthoritiesService authoritiesService;

    @Autowired
	public AccountController(AccountService accountService, CustomerService customerService, UsersService usersService, PasswordGenerator passwordGenerator, AccountNumberGenerator accountNumberGenerator, AuthoritiesService authoritiesService) {
		this.accountService = accountService;
		this.customerService = customerService;
		this.usersService = usersService;
		this.passwordGenerator = passwordGenerator;
		this.accountNumberGenerator = accountNumberGenerator;
		this.authoritiesService = authoritiesService;
	}

	@GetMapping("/showFormForAddAccount")
	public String showFormForAddAccount(Model theModel){
		RegisterObject registerObject = new RegisterObject(new Account(), new Customer(), new Users(), new Authorities());
		theModel.addAttribute("registerObject", registerObject);
		return "account-form";
	}
	
	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute("registerObject") RegisterObject registerObject) {
		RegisterObjectImpl registerObjectImpl = new RegisterObjectImpl(accountService,customerService,usersService,authoritiesService,passwordGenerator,accountNumberGenerator,registerObject);
		registerObjectImpl.insertIntoThreeTablesByOneSubmit();
		return "redirect:/customer/list";
	}

	@ModelAttribute("enable")
	public Map<String,String> getEnableMap(){
		Map<String,String> enableMap = new HashMap<>();
		enableMap.put("true", "True");
		enableMap.put("false" ,"False");
		return enableMap;
	}

	@ModelAttribute("role")
    public Map<String,String> getRoleMap(){
        Map<String,String> roleMap = new HashMap<>();
        roleMap.put("ROLE_EMPLOYEE", "Employee");
        roleMap.put("ROLE_USER", "User");
        return roleMap;
    }
}
