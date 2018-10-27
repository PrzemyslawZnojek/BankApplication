package main.com.java.dao.interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.com.java.entity.Users;

public interface UsersDAO {

	Session createCurrentSession(SessionFactory sf);
	void addUsers(Users theUsers);
	Users getUsers(String username);
	void deleteUser(Users theUsers);
	Users getOneUser(String userName);

}
