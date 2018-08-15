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
	@Column(name="username")
	private String username;

	@Column(name="authority")
	private String authority;

	@OneToOne
	@JoinColumn(name="username", insertable = false, updatable = false)
	private Users users;

	public Authorities() {
	}

	public Authorities(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}

	public String getAuthority() { return authority; }
	public String getUsername() { return username; }
	public Users getUsers() { return users; }

	public void setAuthority(String authority) { this.authority = authority; }
	public void setUsername(String username) { this.username = username; }
	public void setUsers(Users users) { this.users = users; }

	@Override
	public String toString() {
		return "Authorities{" +
				"username='" + username + '\'' +
				", authority='" + authority + '\'' +
				", users=" + users +
				'}';
	}
}
