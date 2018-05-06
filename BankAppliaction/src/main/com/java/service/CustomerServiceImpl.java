package main.com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.AccountDAO;
import main.com.java.dao.CustomerDAO;
import main.com.java.entity.Account;
import main.com.java.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	private AccountDAO accountDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomerList();
	}

	@Override
	@Transactional
	public void addCustomer(Customer theCustomer) {

		customerDAO.addCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(long theId) {
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(long theId) {
		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		   return customerDAO.searchCustomers(theSearchName);
	}

}
