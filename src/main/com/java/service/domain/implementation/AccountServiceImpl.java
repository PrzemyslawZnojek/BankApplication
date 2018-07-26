package main.com.java.service.domain.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.interfaces.AccountDAO;
import main.com.java.entity.Account;
import main.com.java.service.domain.interfaces.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDAO accountDAO;

	@Override
	@Transactional
	public void addAccount(Account theAccount) {
		
		accountDAO.addAccount(theAccount);
		
	}

}