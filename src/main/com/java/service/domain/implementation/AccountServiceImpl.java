package main.com.java.service.domain.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.com.java.dao.interfaces.AccountDAO;
import main.com.java.entity.Account;
import main.com.java.service.domain.interfaces.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    @Transactional
    public void addAccount(Account theAccount) {
        accountDAO.addAccount(theAccount);
    }

    @Override
    @Transactional
    public void deleteAccount(Account theAccount) {
        accountDAO.deleteAccount(theAccount);
    }

    @Override
    @Transactional
    public Account getAccountByUsername(String username) { return accountDAO.getAccountByUsername(username); }

    @Override
    @Transactional
    public List<String> getAccountNumberList() {
        System.out.print("AccountServiceImpl");
        return accountDAO.getAccountNumberList();
    }

}
