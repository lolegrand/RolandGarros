package fr.rolandgarros.rolandgarros.services;

import fr.rolandgarros.rolandgarros.model.Account;
import fr.rolandgarros.rolandgarros.model.dal.AccountDAO;
import fr.rolandgarros.rolandgarros.model.dal.stub.AccountDAOMock;

public class AccountService {

    private final AccountDAO accountDAO = new AccountDAOMock();

    private Account getAccount(String login, String password) {
        return accountDAO.findAccountByLoginPassword(login, password);
    }

}
