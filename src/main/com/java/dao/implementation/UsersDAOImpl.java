package main.com.java.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.com.java.dao.interfaces.UsersDAO;
import main.com.java.entity.Users;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsersDAOImpl implements UsersDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UsersDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Session createCurrentSession(SessionFactory sf) {
        Session session = sf.getCurrentSession();

        return session;
    }

    @Override
    public void addUsers(Users theUsers) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.save(theUsers);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    @Transactional
    public Users getUsers(String username) {
        try {
            return createCurrentSession(sessionFactory).get(Users.class, username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    @Transactional
    public void deleteUser(Users theUsers) {
        try {
            createCurrentSession(sessionFactory).remove(theUsers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users getOneUser(String userName) {
        try {
            return createCurrentSession(sessionFactory).get(Users.class, userName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
