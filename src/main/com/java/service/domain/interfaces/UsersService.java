package main.com.java.service.domain.interfaces;

import main.com.java.entity.Users;
import java.util.List;

public interface UsersService {

	public void addUser(Users theUser);

	//ADDED
	public List<Users> getUsers();

	public Users getOneUser(String userName);
}
