package main.com.java.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.interfaces.CustomerDAO;
import main.com.java.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	private final SessionFactory sessionFactory;

	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

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
	public void addCustomer(Customer theCustomer) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(theCustomer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCustomer(Customer theCustomer) {
		try {
			Session currentSession = createCurrentSession(sessionFactory);
			Query theQuery = currentSession.createQuery("from Customer where id=:customerID");
			theQuery.setParameter("customerID", theCustomer.getCustomerID());

			Customer customer = (Customer)theQuery.list().get(0);
			customer.setFirstName(theCustomer.getFirstName());
			customer.setLastName(theCustomer.getLastName());
			customer.setCountry(theCustomer.getCountry());

			currentSession.update(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	@Transactional
	public Customer getCustomerById(long theId) {
		try {
			return createCurrentSession(sessionFactory).get(Customer.class, theId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void deleteCustomer(long theId) {
		
		Query query = createCurrentSession(sessionFactory).createQuery("delete from Customer where id=:customerID");
		query.setParameter("customerID", theId);
		
		query.executeUpdate();
	}

	@Override
    public List<Customer> searchCustomers(String theSearchName) {
		Query theQuery = null;

		if (theSearchName != null && theSearchName.trim().length() > 0) {
            theQuery =createCurrentSession(sessionFactory).createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }else {
            theQuery =createCurrentSession(sessionFactory).createQuery("from Customer", Customer.class);            
        }

        return theQuery.getResultList();
        
    }

	
}
