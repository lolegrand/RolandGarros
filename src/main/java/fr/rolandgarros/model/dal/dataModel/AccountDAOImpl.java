package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.PersistenceManager;
import fr.rolandgarros.model.Account;
import fr.rolandgarros.model.dal.AccountDAO;


public class AccountDAOImpl implements AccountDAO {

    @Override
    public Account findAccountByLoginPassword(String login, String password) {
        Account account = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Account a WHERE a.login = :login", Account.class)
                    .setParameter("login",login).getSingleResult());

        if (account == null || !account.verifyHash(password)) {
            return null;
        }else {
            return account;
        }
    }

    @Override
    public void createAccount(Account account) {
        PersistenceManager.runInTransaction(entityManager -> {
                entityManager.persist(entityManager.merge(account));
                return null;
            });
    }

    @Override
    public void updateAccount(Account account) {
        PersistenceManager.runInTransaction(entityManager -> {
                entityManager.merge(account);
                return null;
            });
    }

    @Override
    public void deleteAccount(Account account) {
        PersistenceManager.runInTransaction(entityManager -> {
                entityManager.remove(entityManager.merge(account));
                return null;
            });
    }

}
