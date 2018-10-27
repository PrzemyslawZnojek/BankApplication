package main.com.java.service.domain.interfaces;

import main.com.java.entity.Users;

public interface UsersService {

	void addUser(Users theUser);
	void deleteUser(Users theUser);
	Users getUser(String username);
}
