package main.com.java.service.domain.interfaces;

import main.com.java.entity.Account;

import java.util.List;

public interface AccountService {

	void addAccount(Account theAccount);
	void deleteAccount(Account theAccount);
	Account getAccountByUsername(String username);
	List<String> getAccountNumberList();

}
