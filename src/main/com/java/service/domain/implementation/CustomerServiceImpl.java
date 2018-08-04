package main.com.java.service.domain.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.interfaces.CustomerDAO;
import main.com.java.entity.Customer;
import main.com.java.service.domain.interfaces.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerDAO customerDAO;

	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

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
