package main.com.java.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.AccountDAO;
import main.com.java.entity.Account;;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session createCurrentSession(SessionFactory sessionFactory){
		Session session = sessionFactory.getCurrentSession();
		return session;
		
	}
	
	@Override
	@Transactional
	public List<Account> getAccountList() {		
		Query<Account> theQuery = createCurrentSession(sessionFactory).createQuery("from Account", Account.class);		
		List<Account> accountsList = theQuery.getResultList();
		
		return accountsList;
	}

	@Override
	public Account getAccountById(int id) {
		try {			
			return createCurrentSession(sessionFactory).get(Account.class, id);		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void addAccount(Account theAccount) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(theAccount);
			currentSession.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateAccount(Account theAccount) {
		try {
			createCurrentSession(sessionFactory).saveOrUpdate(theAccount);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void removeAccount(Account theAccount) {
		try {
			createCurrentSession(sessionFactory).remove(theAccount);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void saveAccount(Account theAccount) {
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the account 
		currentSession.saveOrUpdate(theAccount);
		currentSession.clear();
	}

	
}
