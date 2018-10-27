package main.com.java.dao.interfaces;

import java.util.List;

import main.com.java.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface AccountDAO {

	List<Account> getAccountList();
	Account getAccountById(int id);
	Account getAccountByUsername(String username);
	void addAccount(Account theAccount); //in usage
	void updateAccount(Account theAccount);
	void deleteAccount(Account theAccount);
	Session createCurrentSession(SessionFactory sf);
	void saveAccount(Account theAccount); //this only in use
	List<String> getAccountNumberList();
	
}
