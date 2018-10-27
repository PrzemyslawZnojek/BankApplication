package main.com.java.service.domain.interfaces;

import java.util.List;

import main.com.java.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();
	void addCustomer(Customer theCustomer);
	Customer getCustomer(long theId);
	void deleteCustomer(long theId);
	List<Customer> searchCustomers(String theSearchName);

}
