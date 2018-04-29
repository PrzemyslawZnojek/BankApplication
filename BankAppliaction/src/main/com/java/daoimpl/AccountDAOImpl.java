package main.com.java.daoimpl;

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
	
	@Override
	@Transactional
	public List<Account> getAccounts() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Account> theQuery = session.createQuery("from Account", Account.class);
		
		List<Account> accountsList = theQuery.getResultList();
		
		return accountsList;
	}

	
}
