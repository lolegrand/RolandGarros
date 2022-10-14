package fr.rolandgarros.rolandgarros.model.dal;

import fr.rolandgarros.rolandgarros.model.Account;

public interface AccountDAO {

    Account findAccountByLoginPassword(String login, String password);

}
