package tests;

import main.com.java.dao.AccountDAO;
import main.com.java.daoimpl.AccountDAOImpl;
import main.com.java.entity.Account;

public class testing {

	public static void main(String[] args) {

		Account account = new Account(123L, 90000L, "123123123", "loko");
		
		AccountDAO accountDAO = new AccountDAOImpl();
		accountDAO.addAccount(account);

	}

}
