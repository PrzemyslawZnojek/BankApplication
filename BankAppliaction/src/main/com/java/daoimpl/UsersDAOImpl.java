package main.com.java.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.com.java.dao.UsersDAO;
import main.com.java.entity.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
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
	public Users getUsers(String username) {
		Users theUsers = createCurrentSession(sessionFactory).get(Users.class, username);
		
		return theUsers;
	}

}