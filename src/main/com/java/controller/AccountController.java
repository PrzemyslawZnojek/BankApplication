package main.com.java.controller;

import main.com.java.entity.*;
import main.com.java.service.business.registerObject.RegisterObjectService;
import main.com.java.service.domain.interfaces.AuthoritiesService;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import main.com.java.service.business.generators.AccountNumberGenerator;
import main.com.java.service.business.generators.PasswordGenerator;
import main.com.java.service.domain.interfaces.AccountService;
import main.com.java.service.domain.interfaces.CustomerService;
import main.com.java.service.domain.interfaces.UsersService;

import java.util.HashMap;
import java.util.List;
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

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> theCustomers = customerService.getCustomers();

		theModel.addAttribute("customers", theCustomers);

		return "main";
	}

	@GetMapping("/showFormForAddAccount")
	public String showFormForAddAccount(Model theModel){
		RegisterObject registerObject = new RegisterObject(new Account(), new Customer(), new Users(), new Authorities());

		theModel.addAttribute("registerObject", registerObject);

		return "accountAdding-form";
	}

	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute("registerObject") RegisterObject registerObject, Model theModel) {
		RegisterObjectService registerObjectService = new RegisterObjectService.RegisterObjectBuilder()
				.usersService(usersService)
				.customerService(customerService)
				.accountService(accountService)
				.authoritiesService(authoritiesService)
				.accountNumberGenerator(accountNumberGenerator)
				.passwordGenerator(passwordGenerator)
				.registerObject(registerObject)
				.build();

		registerObjectService.insertIntoThreeTablesByOneSubmit();

		// This moment is clue. I need to store this password and transfer it to new jsp Window.
		System.out.println(passwordGenerator.generatePassword());
		System.out.println(passwordGenerator.getPassword());
		//

		Users user = usersService.getOneUser("john");

		//theModel.addAttribute("customers", user);

		Map<String, String> map = new HashMap<>();
		map.put("spring", "mvc");
		theModel.addAttribute("username", user.getUsername());
		theModel.addAttribute("password", user.getPassword());
		theModel.mergeAttributes(map);

        //List<Users> theUsers = usersService.getUsers();
		//System.out.println(theUsers);
		//theModel.addAttribute("customers", theUsers);

		//return "redirect:/customer/list";
		return "showPasswordForUser";
		//return "redirect:/customer/showPasswordForUser";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerID") long theId, Model theModel){
		Customer theCustomer = customerService.getCustomer(theId);

		theModel.addAttribute("customer", theCustomer);

		return "customerUpdate-form";

	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerID") long theId) {

		customerService.deleteCustomer(theId);

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
