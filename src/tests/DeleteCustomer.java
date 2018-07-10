package tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import main.com.java.entity.Account;
import main.com.java.entity.Customer;
//import main.com.java.entity.OrderItem;

public class DeleteCustomer {

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
			
			//delete the student
			//System.out.println("Deleting Customer with id: " + myCustomer.getCustomerID());
			//session.delete(myCustomer);
			
			//delete where id=2
			System.out.println("Deleting customer with id=2");
			
			session.createQuery("delete from Customer where CustomerID=2").executeUpdate();
			//commit
			session.getTransaction().commit();
			
			System.out.println("DONE!!");
			
		} finally {
			factory.close();
		}

	}

}
