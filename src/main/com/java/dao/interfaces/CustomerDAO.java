package main.com.java.dao.interfaces;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.com.java.entity.Account;
import main.com.java.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomerList();
	Customer getCustomerById(long id);
	void addCustomer(Customer theCustomer);
	void updateCustomer(Customer theCustomer);
	Session createCurrentSession(SessionFactory sf);
	void deleteCustomer(long theId);
	List<Customer> searchCustomers(String theSearchName);
}
