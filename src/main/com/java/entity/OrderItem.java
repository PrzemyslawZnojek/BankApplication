package main.com.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderitem")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderItemID")
	private long orderItemID;
	
	@Column(name="amount")
	private long amount;
	
	@Column(name="accountNumberSender")
	private String accountNumberSender;
	
	@Column(name="accountNumberReceiver")
	private String accountNumberReceiver;
	
//	@ManyToOne
//    @JoinColumn(name="accountNumberSender", insertable = false, updatable = false)
//    private Account senderAccount;
//
//    @ManyToOne
//    @JoinColumn(name="accountNumberReceiver", insertable = false, updatable = false)
//    private Account receiverAccount;

	public OrderItem() {}
	
	public OrderItem(long amount, String accountNumberSender, String accountNumberReceiver) {
		this.amount = amount;
		this.accountNumberSender = accountNumberSender;
		this.accountNumberReceiver = accountNumberReceiver;
	}
	
//
//	public Account getSenderAccount() {
//		return senderAccount;
//	}
//
//	public Account getReceiverAccount() {
//		return receiverAccount;
//	}
//
//	public void setSenderAccount(Account senderAccount) {
//		this.senderAccount = senderAccount;
//	}
//
//	public void setReceiverAccount(Account receiverAccount) {
//		this.receiverAccount = receiverAccount;
//	}

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
