package tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.com.java.entity.Account;
//import main.com.java.entity.Account;
import main.com.java.entity.Customer;
//import main.com.java.entity.OrderItem;

public class CascadeTryForCustomerAndAccount {

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
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			long theId = 3;
			Customer tempCustomer =
					session.get(Customer.class, theId);
			
			//sysouts
			System.out.println("tempCustomer: " + tempCustomer);
			System.out.println("the associated Account: " + tempCustomer.getAccount());
			
			//delete
			session.delete(tempCustomer);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("DONE!!");
			
		} finally {
			factory.close();
		}

	}

}
