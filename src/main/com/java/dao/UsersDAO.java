package main.com.java.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.com.java.entity.Users;

public interface UsersDAO {

	public Session createCurrentSession(SessionFactory sf);
	public void addUsers(Users theUsers);
	public Users getUsers(String username);

}
