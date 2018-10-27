package main.com.java.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.interfaces.OrderItemDAO;
import main.com.java.entity.Account;
import main.com.java.entity.Customer;
import main.com.java.entity.OrderItem;

@Repository
public class OrderItemDAOImpl implements OrderItemDAO{

	private final SessionFactory sessionFactory;

	@Autowired
	public OrderItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public Session createCurrentSession(SessionFactory sf){
		Session session = sf.getCurrentSession();

		return session;
	}

	@Override
	public List<OrderItem> getOrderItemList() {
		Query<OrderItem> theQuery = createCurrentSession(sessionFactory).createQuery("from OrderItem", OrderItem.class);
		List<OrderItem> orderItemsList = theQuery.getResultList();

		return orderItemsList;
	}

    @Override
	@Transactional
    public List<OrderItem> getOrderItemListSender(String accountNumberSenderValue) {
        String hql = "FROM OrderItem WHERE accountNumberSender=:accountNumberSenderParam";
        Query theQuery = createCurrentSession(sessionFactory).createQuery(hql);
        theQuery.setParameter("accountNumberSenderParam", accountNumberSenderValue);
        List resultList = theQuery.getResultList();
        return resultList;

    }


    @Override
    public List<OrderItem> getOrderItemListReceiver(String accountNumberReceiverValue) {
        String hql = "FROM OrderItem WHERE accountNumberReceiver=:accountNumberReceiverParam";
        Query theQuery = createCurrentSession(sessionFactory).createQuery(hql);
        theQuery.setParameter("accountNumberReceiverParam", accountNumberReceiverValue);
        return theQuery.getResultList();
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
	public void deleteOrderItem(OrderItem theOrderItem) {
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
	public void saveTransfer(OrderItem theOrderItem, Account account, String Send, String Rec, long amount) {

		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
//		Query query1 = currentSession.createQuery("UPDATE account SET balance = 999999 where accountNumber= :Send");
//		query1.setParameter("Send", Send);
//		query1.executeUpdate();
//		Query query2 = currentSession.createQuery("UPDATE account SET balance = 999999 where accountNumber= :Rec");
//		query2.setParameter("Rec", Rec);
//		query2.executeUpdate();
		
		String dbQuery = "UPDATE Account SET balance = balance - :amount where accountNumber= :Send";
		Query q1 =  currentSession.createQuery(dbQuery).setParameter("Send", Send).setParameter("amount", amount);
		
		String dbQuery2 = "UPDATE Account SET balance = balance + :amount1 where accountNumber= :Rec";
		Query q2 =  currentSession.createQuery(dbQuery2).setParameter("Rec", Rec).setParameter("amount1", amount);
		int result = q1.executeUpdate();
		int result2 = q2.executeUpdate();
		
		//save the orderItem 
		currentSession.save(theOrderItem);
		
	}



}
