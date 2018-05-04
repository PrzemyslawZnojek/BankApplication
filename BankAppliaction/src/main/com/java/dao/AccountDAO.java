package main.com.java.dao;

import java.util.List;

import main.com.java.entity.Account;

public interface AccountDAO {

	public List<Account> getAccounts();
	public Account getAccountById(int id);
	public void addAccount(Account theAccount);
	public void updateAccount(Account theAccount);
	public void removeAccount(Account theAccount);
}
