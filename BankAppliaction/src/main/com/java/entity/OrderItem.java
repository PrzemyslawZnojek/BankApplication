package main.com.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderItem")
public class OrderItem {
	
	@Id
	@Column(name="orderItemID")
	private long orderItemID;
	
	@Column(name="amount")
	private long amount;
	
	@Column(name="accountNumberSender")
	private String accountNumberSender = "";
	
	@Column(name="accountNumberReceiver")
	private String accountNumberReceiver = "";
	
	public OrderItem(long orderItemID, long amount, String accountNumberSender, String accountNumberReceiver) {
		this.orderItemID = orderItemID;
		this.amount = amount;
		this.accountNumberSender = accountNumberSender;
		this.accountNumberReceiver = accountNumberReceiver;
	}
	
	public long getOrderItemID() {
		return orderItemID;
	}
	public void setOrderItemID(long orderItemID) {
		this.orderItemID = orderItemID;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getAccountNumberSender() {
		return accountNumberSender;
	}
	public void setAccountNumberSender(String accountNumberSender) {
		this.accountNumberSender = accountNumberSender;
	}
	public String getAccountNumberReceiver() {
		return accountNumberReceiver;
	}
	public void setAccountNumberReceiver(String accountNumberReceiver) {
		this.accountNumberReceiver = accountNumberReceiver;
	}

	
}
