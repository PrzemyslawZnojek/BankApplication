package main.com.java.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.com.java.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomerList();
	public Customer getCustomerById(int id);
	public void addCustomer(Customer theCustomer);
	public void removeCustomer(Customer theCustomer);
	public void updateCustomer(Customer theCustomer);
	public Session createCurrentSession(SessionFactory sf);
	public Customer getCustomer(long theId);
}
