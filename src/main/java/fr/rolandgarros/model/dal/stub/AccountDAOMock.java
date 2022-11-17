package fr.rolandgarros.model.dal.stub;

import fr.rolandgarros.model.dal.AccountDAO;
import fr.rolandgarros.model.Account;
import fr.rolandgarros.model.Role;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
        accounts.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        // Not implemented in Mock class.
    }

    @Override
    public void deleteAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public Account getAccountById(int account) {
        for (Account account1 : accounts) {
            if (Objects.equals(account1.getIdAccount(), account)) {
                return account1;
            }
        }
        return null;
    }

    @Override
    public List<Account> getAllAccount() {
        return accounts;
    }
}
