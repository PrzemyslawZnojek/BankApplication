package main.com.java.daoimpl;

import java.util.List;

import javax.print.attribute.standard.RequestingUserName;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.CustomerDAO;
import main.com.java.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = theQuery.getResultList();

		return customers;
	}

	@Override
	public Customer getCustomferById(int id) {
		
		Customer tomek = new Customer();
		return tomek;
	}

	@Override
	public void addCustomer(Customer theCustomer) {

		
	}

	@Override
	public void removeCustomer(Customer theCustomer) {

		
	}

	@Override
	public void updateCustomer(Customer theCustomer) {

		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.save(theCustomer);
		
	}

	
	
}
