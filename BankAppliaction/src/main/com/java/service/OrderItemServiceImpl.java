package main.com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.OrderItemDAO;
import main.com.java.entity.Account;
import main.com.java.entity.OrderItem;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDAO orderItemDAO;

	@Override
	@Transactional
	public void saveTransfer(OrderItem theOrderItem, Account account, String send, String rec, long amount) {
		orderItemDAO.saveTransfer(theOrderItem, account, send, rec, amount);
		
	}
}

