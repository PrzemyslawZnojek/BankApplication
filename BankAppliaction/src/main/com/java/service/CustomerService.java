package main.com.java.service;

import java.util.List;

import main.com.java.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
