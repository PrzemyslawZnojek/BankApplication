package main.com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import main.com.java.dao.CustomerDAO;
import main.com.java.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject DAO into customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customer from DAO
		List<Customer> theCustomers = customerDAO.getCustomersList();
		
		// add customer to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@RequestMapping("/addCustomer")
	public String addCustomer(Model theModel){
		return "add-customer";
	}

}
