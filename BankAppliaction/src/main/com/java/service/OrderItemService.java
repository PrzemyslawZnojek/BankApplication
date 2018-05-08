package main.com.java.service;

import main.com.java.entity.Account;
import main.com.java.entity.OrderItem;

public interface OrderItemService {

	public void saveTransfer(OrderItem theOrderItem, Account account, String send, String rec, long amount);

}
