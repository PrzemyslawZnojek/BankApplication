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
	
	@Column(name="password")
	private String password;
	
	@Column(name="username")
	private String username;
	
	@Column(name="admin")
	private Boolean admin;

	public Account(long customerID, long balance, String accountNumber, String password, String username, Boolean admin) {
		this.customerID = customerID;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.password = password;
		this.username = username;
		this.admin = admin;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	
	
}
