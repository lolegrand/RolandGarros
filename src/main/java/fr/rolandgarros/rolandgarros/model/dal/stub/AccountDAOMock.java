package fr.rolandgarros.rolandgarros.model.dal.stub;

import fr.rolandgarros.rolandgarros.model.Account;
import fr.rolandgarros.rolandgarros.model.Role;
import fr.rolandgarros.rolandgarros.model.dal.AccountDAO;

import java.util.LinkedList;
import java.util.List;

public class AccountDAOMock implements AccountDAO {

    List<Account> accounts = new LinkedList<Account>() {{
        add(new Account("TrainerOne", "T1", Role.TRAINER));
        add(new Account("TrainerTwo", "T2", Role.TRAINER));
        add(new Account("MatchEditorOne", "ME1", Role.TRAINER));
        add(new Account("PlayerEditorOne", "PE1", Role.TRAINER));
        add(new Account("Admin", "Admin", Role.ADMINISTRATOR));
    }};

    @Override
    public Account findAccountByLoginPassword(String login, String password) {
        for (Account account : accounts) {
            if (login.equals(account.getLogin()) && password.equals(account.getPassword())) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void createAccount(Account account) {
        this.accounts.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        this.accounts.remove(account);
        this.accounts.add(account);
    }

    @Override
    public void deleteAccount(Account account) {
        this.accounts.add(account);
    }
}
