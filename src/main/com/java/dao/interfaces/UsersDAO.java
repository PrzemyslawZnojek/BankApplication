package main.com.java.dao.interfaces;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.com.java.entity.Users;

public interface UsersDAO {

    public Session createCurrentSession(SessionFactory sf);
    public void addUsers(Users theUsers);
    public List<Users> getUsersList();
    public Users getOneUser(String userName);

}
