package tests;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import main.com.java.entity.Account;
import main.com.java.entity.Customer;
//import main.com.java.entity.OrderItem;

public class QueryCustomer {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query customers
			List<Customer> theCustomers = session.createQuery("from Customer").getResultList();
			
			// display customers
			for( Customer customer : theCustomers) {
				System.out.println(customer);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("DONE!!");
			
		} finally {
			factory.close();
		}

	}

}
