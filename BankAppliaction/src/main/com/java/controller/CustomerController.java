package main.com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.com.java.entity.Customer;
import main.com.java.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject customerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customer from Service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add customer to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "main";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		customerService.addCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	
	@RequestMapping("/addCustomer")
	public String addCustomer(Model theModel){
		return "add-customer";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerID") long theId, Model theModel){
		
		// get customer from service
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set customer as model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to out form
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerID") long theId) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	@PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "main";        
    }

	
}
