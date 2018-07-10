package tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import main.com.java.entity.Account;
import main.com.java.entity.Customer;
//import main.com.java.entity.OrderItem;

public class ReadCustomer {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a object
			System.out.println("Creating new student object");
			Customer customer = new Customer("7000", "1234567", "99887766");
			
			// start a transaction
			session.beginTransaction();
			
			// save the object
			System.out.println("Saving item");
			System.out.println(customer);
			session.save(customer);
			
			// commit transaction
			session.getTransaction().commit();
			
			// NEW CODE
			System.out.println("New customer ID:" + customer.getCustomerID());
			
			
			
			//get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve customer by ID
			System.out.println("\nGetting Customer with id: " + customer.getCustomerID());
			
			Customer myCustomer = session.get(Customer.class, customer.getCustomerID());
			
			System.out.println("Get complete: " + myCustomer);
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("DONE!!");
			
		} finally {
			factory.close();
		}

	}

}
