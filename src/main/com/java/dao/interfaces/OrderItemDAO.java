package main.com.java.dao.interfaces;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.com.java.entity.Account;
import main.com.java.entity.OrderItem;

public interface OrderItemDAO {

	List<OrderItem> getOrderItemList();
    List<OrderItem> getOrderItemListSender(String accountNumberSender);
    List<OrderItem> getOrderItemListReceiver(String accountNumberReceiver);
	OrderItem getOrderItemById(int id);
	void addOrderItem(OrderItem theOrderItem);
	void deleteOrderItem(OrderItem theOrderItem);
	void updateOrderItem(OrderItem theOrderItem);
	Session createCurrentSession(SessionFactory sf);
	void saveTransfer(OrderItem theOrderItem, Account account, String send, String rec, long amount);
}
