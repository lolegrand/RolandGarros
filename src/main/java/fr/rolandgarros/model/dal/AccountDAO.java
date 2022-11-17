package fr.rolandgarros.model.dal;

import fr.rolandgarros.model.Account;

import java.util.List;

public interface AccountDAO {
    Account findAccountByLoginPassword(String login, String password);

    void createAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Account account);

    Account getAccountById(int account);
    List<Account> getAllAccount();

}
