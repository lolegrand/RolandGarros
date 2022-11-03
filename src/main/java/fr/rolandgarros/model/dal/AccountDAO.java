package fr.rolandgarros.model.dal;

import fr.rolandgarros.model.Account;

public interface AccountDAO {
    Account findAccountByLoginPassword(String login, String password);

    void createAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Account account);

}
