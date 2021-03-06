package main.com.java.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.interfaces.AccountDAO;
import main.com.java.entity.Account;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class AccountDAOImpl implements AccountDAO{

	private final SessionFactory sessionFactory;

	@Autowired
	public AccountDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

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
	public Account getAccountByUsername(String username) {
		try {
			String hql = "FROM Account WHERE username=:usernameParam";
			Query theQuery = createCurrentSession(sessionFactory).createQuery(hql);
			theQuery.setParameter("usernameParam", username);
			return (Account)theQuery.list().get(0);

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
	@Transactional
	public void deleteAccount(Account theAccount) {
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

	@Override
	public List<String> getAccountNumberList(){

		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<String> query = builder.createQuery(String.class);
        System.out.print("query = " + query);
		Root<Account> root = query.from(Account.class);
		query.select(root.get("accountNumber"));
	    Query<String> theQuery = createCurrentSession(sessionFactory).createQuery(query);

		return theQuery.getResultList();
	}

	
}
