package main.com.java.daoimpl;

import java.util.List;

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
	
	public Session createCurrentSession(SessionFactory sf){
		Session session = sf.getCurrentSession();
		
		return session;
	}
	
	@Override
	@Transactional
	public List<Customer> getCustomerList() {
		
		Query<Customer> theQuery = createCurrentSession(sessionFactory).createQuery("from Customer", Customer.class);		
		List<Customer> customersList = theQuery.getResultList();
		
		return customersList;
	}

	@Override
	public Customer getCustomerById(int id) {
		try {			
			return createCurrentSession(sessionFactory).get(Customer.class, id);		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void addCustomer(Customer theCustomer) {
		try {
			createCurrentSession(sessionFactory).save(theCustomer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeCustomer(Customer theCustomer) {
		try {
			createCurrentSession(sessionFactory).remove(theCustomer);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void updateCustomer(Customer theCustomer) {
		try {
			createCurrentSession(sessionFactory).update(theCustomer);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	
}
