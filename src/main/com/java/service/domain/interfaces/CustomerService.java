package main.com.java.service.domain.interfaces;

import java.util.List;

import main.com.java.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void addCustomer(Customer theCustomer);

	public Customer getCustomer(long theId);

	public void deleteCustomer(long theId);

	public List<Customer> searchCustomers(String theSearchName);

}
