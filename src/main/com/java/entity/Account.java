package main.com.java.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accountID")
	private long accountID;

	@Column(name="balance")
	private long balance;

	@Column(name="accountNumber")
	private String accountNumber;

	@Column(name="username")
	private String username;

	@OneToOne(mappedBy="account", cascade=CascadeType.ALL)
	private Customer customer;

	@OneToOne(mappedBy="account", cascade=CascadeType.ALL)
	private Users users;


	@OneToMany(mappedBy="senderAccount")
    private Collection<OrderItem> payers;

    @OneToMany(mappedBy="receiverAccount")
    private Collection<OrderItem> receivers;

	public Account() {}

	public Account(long balance, String accountNumber, String password, String username, Boolean admin) {
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.username = username;
	}

	public long getAccountID() {
		return accountID;
	}

	public long getBalance() {
		return balance;
	}


	public String getUsername() {
		return username;
	}

	public Customer getCustomer() {
		return customer;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance
				+ ", accountNumber=" + accountNumber + ", username=" + username + ", customer=" + customer + "]";
	}

	
}
