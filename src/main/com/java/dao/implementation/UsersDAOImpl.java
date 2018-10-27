package main.com.java.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.com.java.dao.interfaces.UsersDAO;
import main.com.java.entity.Users;

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

	//ADDED
	@Override
	@Transactional
	public List<Users> getUsersList() {

		Query<Users> theQuery = createCurrentSession(sessionFactory).createQuery("from Users", Users.class);
		List<Users> usersList = theQuery.getResultList();

		return usersList;
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
