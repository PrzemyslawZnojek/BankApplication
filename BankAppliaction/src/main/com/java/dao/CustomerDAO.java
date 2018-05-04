package main.com.java.dao;

import java.util.List;

import main.com.java.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	public Customer getCustomferById(int id);
	public void addCustomer(Customer theCustomer);
	public void removeCustomer(Customer theCustomer);
	public void updateCustomer(Customer theCustomer);
	public void saveCustomer(Customer theCustomer);
}
