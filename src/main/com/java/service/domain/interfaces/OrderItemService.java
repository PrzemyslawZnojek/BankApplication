package main.com.java.service.domain.interfaces;

import java.util.List;

import main.com.java.entity.Account;
import main.com.java.entity.OrderItem;

public interface OrderItemService {

	void saveTransfer(OrderItem theOrderItem, Account account, String send, String rec, long amount);
    List<OrderItem> getOrderItemListSender(String accountNumberSender);
    List<OrderItem> getOrderItemListReceiver(String accountNumberReceiver);
	List<OrderItem> getOrderItems();

}
