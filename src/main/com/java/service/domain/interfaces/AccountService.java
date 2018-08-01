package main.com.java.service.domain.interfaces;

import main.com.java.entity.Account;

import java.util.List;

public interface AccountService {

	public void addAccount(Account theAccount);
	public List<String> getAccountNumberList();

}
