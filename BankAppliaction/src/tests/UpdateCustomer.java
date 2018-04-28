package tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import main.com.java.entity.Account;
import main.com.java.entity.Customer;
//import main.com.java.entity.OrderItem;

public class UpdateCustomer {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			long customerID = 1;
			
			
			//get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve customer by ID
			System.out.println("\nGetting Customer with id: " + customerID);
			
			Customer myCustomer = session.get(Customer.class, customerID);
			
			System.out.println("Updating students");
			myCustomer.setFirstName("Leon");
			
			//commit
			session.getTransaction().commit();
			
			//NEW ONE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update all first names");
			
			session.createQuery("update Customer set firstName='JOHN'")
			.executeUpdate();
			
			System.out.println("DONE!!");
			
		} finally {
			factory.close();
		}

	}

}
