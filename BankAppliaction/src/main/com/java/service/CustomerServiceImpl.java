package main.com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.CustomerDAO;
import main.com.java.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

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

}