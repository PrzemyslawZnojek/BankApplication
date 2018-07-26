package main.com.java.dao.interfaces;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.com.java.entity.Account;
import main.com.java.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomerList();
	public Customer getCustomerById(int id); // can remove this probably.. cuz of duplicate with getCustomer
	public void addCustomer(Customer theCustomer);
	public void updateCustomer(Customer theCustomer);
	public Session createCurrentSession(SessionFactory sf);
	public Customer getCustomer(long theId);
	public void deleteCustomer(long theId);
	public List<Customer> searchCustomers(String theSearchName);
}
