package main.com.java.service;

import java.util.List;

import main.com.java.entity.Account;
import main.com.java.entity.OrderItem;

public interface OrderItemService {

	public void saveTransfer(OrderItem theOrderItem, Account account, String send, String rec, long amount);
	public List<OrderItem> getOrderItems();

}
