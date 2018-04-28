package main.com.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@Column(name="accountID")
	private long accountID;
	
	
	@Column(name="customerID")
	private long customerID;
	
	@Column(name="balance")
	private long balance;
	
	@Column(name="accountNumber")
	private String accountNumber;

	public Account(long customerID, long balance, String accountNumber) {
		this.customerID = customerID;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public long getAccountID() {
		return accountID;
	}

	public long getCustomerID() {
		return customerID;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
