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

	@OneToOne(mappedBy="users", cascade=CascadeType.ALL)
	private Account account;
	
	@OneToOne(mappedBy="users", cascade=CascadeType.ALL)
	private Authorities authorities;
	
}
