package main.com.java.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Column(name="idOfCustomer")
	private long idOfCustomer;
	
	@Column(name="balance")
	private long balance;
	
	@Column(name="accountNumber")
	private String accountNumber;
	
	@Column(name="password")
	private String password;
	
	@Column(name="admin")
	private Boolean admin;
	
	@Column(name="username")
	private String username;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idOfCustomer", insertable = false, updatable = false)
	private Customer customer;
	
	public Collection<OrderItem> getPayers() {
		return payers;
	}

	public Collection<OrderItem> getReceivers() {
		return receivers;
	}

	public void setPayers(Collection<OrderItem> payers) {
		this.payers = payers;
	}

	public void setReceivers(Collection<OrderItem> receivers) {
		this.receivers = receivers;
	}

	@OneToMany(mappedBy="senderAccount")
    private Collection<OrderItem> payers;

    @OneToMany(mappedBy="receiverAccount")
    private Collection<OrderItem> receivers;

	//@OneToMany @JoinColumn(name = "accountNumberReceiver")
	//private OrderItem receiver;
	
	public Account() {}
	
	public Account(long balance, String accountNumber, String password, String username, Boolean admin) {
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.password = password;
		this.username = username;
		this.admin = admin;
	}

	public long getAccountID() {
		return accountID;
	}

	public long getIdOfCustomer() {
		return idOfCustomer;
	}
	
	public long getBalance() {
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	
	public void setIdOfCustomer(long idOfCustomer) {
		this.idOfCustomer = idOfCustomer;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance
				+ ", accountNumber=" + accountNumber + ", password=" + password + ", username=" + username + ", admin="
				+ admin + ", customer=" + customer + "]";
	}

	
}
