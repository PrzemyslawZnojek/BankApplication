package main.com.java.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customerID")
	private long customerID;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="country")
	private String country;
	
	@OneToOne(mappedBy="customer", cascade=CascadeType.ALL)
	private Account account;

	public Customer() {}
	
	public Customer(String firstName, String lastName, String country) {	
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
	}
	
	public long getCustomerID() {
		return customerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	// for log diagnose.
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", country=" + country + "]";
	}

	
	
}
