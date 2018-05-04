package main.com.java.dao;

import java.util.List;

import javax.persistence.criteria.Order;

import main.com.java.entity.OrderItem;

public interface OrderItemDAO {

	public List<OrderItem> getOrderItemList();
	public OrderItem getOrderItemById(int id);
	public void getOrderItem(OrderItem theOrderItem);
	public void removeOrderItem(OrderItem theOrderItem);
	public void updateOrderItem(OrderItem theOrderItem);
}
