package main.com.java.entity;

import javax.persistence.*;


@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customerID")
	private long customerID;

	@Column(name="idOfAccount")
	private long idOfAccount;

	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="country")
	private String country;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idOfAccount", insertable = false, updatable = false)
	private Account account;

	public Customer() {}
	
	public Customer(long idOfAccount, String firstName, String lastName, String country) {
		this.idOfAccount = idOfAccount;
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
    public Account getAccount() {
        return account;
    }

    public void setIdOfAccount(long idOfAccount) { this.idOfAccount = idOfAccount;}
    public void setAccount(Account account) { this.account = account; }


	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public long getIdOfAccount() {
		return idOfAccount;
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

	@Override
    public String toString() {
        return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
                + ", country=" + country + "]";
    }

	
	
}
