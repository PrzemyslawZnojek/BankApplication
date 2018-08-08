package main.com.java.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="enabled")
	private boolean enabled;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username", insertable = false, updatable = false)
	private Account account;

	@OneToOne(mappedBy="users", cascade=CascadeType.ALL)
	private Authorities authorities;



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Authorities getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
	
	
	
}
