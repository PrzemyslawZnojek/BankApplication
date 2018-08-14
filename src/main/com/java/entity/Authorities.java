package main.com.java.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authorities {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="authority")
	private String authority;
	
	@Column(name="username")
	private String username;
	
	@OneToOne
	@JoinColumn(name="username", insertable = false, updatable = false)
	private Users users;
}
