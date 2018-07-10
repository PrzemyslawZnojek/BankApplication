package tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.com.java.entity.Account;
//import main.com.java.entity.Account;
import main.com.java.entity.Customer;
//import main.com.java.entity.OrderItem;

public class CreateCustomer {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the object
			Customer theCustomer = new Customer("John", "Doe", "Poland");
			
			Account theAccount = new Account(1000, "x", "x", "d", false);
			
			//associate the object
			theAccount.setCustomer(theCustomer);
			
			// start a transaction
			session.beginTransaction();
			
			// save Account
			session.save(theAccount);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("DONE!!");
			
		} finally {
			factory.close();
		}

		

	}

}
