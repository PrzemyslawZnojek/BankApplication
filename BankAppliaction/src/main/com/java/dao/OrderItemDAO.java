package main.com.java.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.com.java.entity.OrderItem;

public interface OrderItemDAO {

	public List<OrderItem> getOrderItemList();
	public OrderItem getOrderItemById(int id);
	public void addOrderItem(OrderItem theOrderItem);
	public void removeOrderItem(OrderItem theOrderItem);
	public void updateOrderItem(OrderItem theOrderItem);
	public Session createCurrentSession(SessionFactory sf);
	public void saveTransfer(OrderItem theOrderItem);
}
