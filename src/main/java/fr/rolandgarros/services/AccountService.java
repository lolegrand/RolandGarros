package fr.rolandgarros.services;

import fr.rolandgarros.model.Account;
import fr.rolandgarros.model.dal.AccountDAO;
import fr.rolandgarros.model.dal.dataModel.AccountDAOImpl;
import fr.rolandgarros.model.dal.stub.AccountDAOMock;

public class AccountService {
    private final AccountDAO accountDAO = new AccountDAOMock();
    //private final AccountDAO accountDAO = new AccountDAOImpl();

    public Account getAccount(String login, String password) {
        return accountDAO.findAccountByLoginPassword(login, password);
    }

    public void createAccount(Account account) {
        accountDAO.createAccount(account);
    }

    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    public void deleteAccount(Account account) {
        accountDAO.deleteAccount(account);
    }

}
