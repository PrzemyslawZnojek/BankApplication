package main.com.java.entity;

public class Account {

	private long accountID;
	private long customerID;
	private long balance;
	private String accountNumber;

	public Account(long accountID, long customerID, long balance, String accountNumber) {
		this.accountID = accountID;
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
