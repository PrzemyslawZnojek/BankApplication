package main.com.java.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.OrderItemDAO;
import main.com.java.entity.Account;
import main.com.java.entity.Customer;
import main.com.java.entity.OrderItem;

@Repository
public class OrderItemDAOImpl implements OrderItemDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session createCurrentSession(SessionFactory sf){
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		
		return session;
	}
	
	@Override
	public List<OrderItem> getOrderItemList() {
		Query<OrderItem> theQuery = createCurrentSession(sessionFactory).createQuery("from OrderItem", OrderItem.class);		
		List<OrderItem> orderItemsList = theQuery.getResultList();
		
		return orderItemsList;
	}

	@Override
	public OrderItem getOrderItemById(int id) {
		try {			
			return createCurrentSession(sessionFactory).get(OrderItem.class, id);		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public void addOrderItem(OrderItem theOrderItem) {
		try {
			createCurrentSession(sessionFactory).save(theOrderItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void removeOrderItem(OrderItem theOrderItem) {
		try {
			createCurrentSession(sessionFactory).remove(theOrderItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateOrderItem(OrderItem theOrderItem) {
		try {
			createCurrentSession(sessionFactory).update(theOrderItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveTransfer(OrderItem theOrderItem) {

		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the account 
		currentSession.save(theOrderItem);
		
	}



}
