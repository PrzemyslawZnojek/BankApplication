package main.com.java.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {

	@Id
	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="enabled")
	private boolean enabled;

	@OneToOne
	@JoinColumn(name="username", insertable = false, updatable = false)
	private Account account;

	@OneToOne(mappedBy="users", cascade=CascadeType.ALL)
	private Authorities authorities;



	public String getUsername() {
		return username;
	}
	public String getPassword() { return password;}
	public Account getAccount() {
		return account;
	}
	public Authorities getAuthorities() {
		return authorities;
	}

	public void setUsername(String username) { this.username = username; }
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
	public boolean isEnabled() {
		return enabled;
	}

	
	
}
