package main.com.java.entity;

public class OrderItem {
	
	private long orderItemID;
	private long amount;
	private String accountNumberSender = "";
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
