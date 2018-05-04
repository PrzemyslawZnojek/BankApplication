package main.com.java.dao;

import java.util.List;

import main.com.java.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface AccountDAO {

	public List<Account> getAccountList();
	public Account getAccountById(int id);
	public void addAccount(Account theAccount);
	public void updateAccount(Account theAccount);
	public void removeAccount(Account theAccount);
	public Session createCurrentSession(SessionFactory sf);
	
}
