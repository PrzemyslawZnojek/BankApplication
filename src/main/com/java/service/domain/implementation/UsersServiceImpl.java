package main.com.java.service.domain.implementation;

import java.util.List;

import main.com.java.dao.interfaces.UsersDAO;
import main.com.java.entity.Users;
import main.com.java.service.domain.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersDAO usersDAO;

    @Autowired
    public UsersServiceImpl(UsersDAO usersDAO) { this.usersDAO = usersDAO; }


    @Override
    @Transactional
    public void addUser(Users theUser) {
        usersDAO.addUsers(theUser);
    }

    //ADDED
    @Override
    @Transactional
    public List<Users> getUsers() {
        return usersDAO.getUsersList();
    }

    @Override
    @Transactional
    public Users getOneUser(String userName) {
        return usersDAO.getOneUser(userName);
    }
}
