package fr.rolandgarros.rolandgarros.model.dal;

import fr.rolandgarros.rolandgarros.model.Account;
import fr.rolandgarros.rolandgarros.model.Role;

public interface AccountDAO {

    Account findAccountByLoginPassword(String login, String password);

    void createAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Account account);

}
