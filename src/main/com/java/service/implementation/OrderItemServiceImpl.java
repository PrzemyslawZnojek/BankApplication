package main.com.java.service.implementation;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.OrderItemDAO;
import main.com.java.entity.Account;
import main.com.java.entity.OrderItem;
import main.com.java.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDAO orderItemDAO;

	@Override
	@Transactional
	public void saveTransfer(OrderItem theOrderItem, Account account, String send, String rec, long amount) {
		orderItemDAO.saveTransfer(theOrderItem, account, send, rec, amount);
		
	}
	
	@Override
	@Transactional
	public List<OrderItem> getOrderItems(){
		
		return orderItemDAO.getOrderItemList();
	}
}

