package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.PersistenceManager;
import fr.rolandgarros.model.Account;
import fr.rolandgarros.model.dal.AccountDAO;


import java.util.List;

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
                entityManager.persist(account);
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

    @Override
    public Account getAccountById(int account) {
        Account accountOut;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            accountOut = entityManager.createQuery("SELECT Account FROM Account WHERE Account.id=id", Account.class)
                    .setParameter("id", account)
                    .getSingleResult();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }

        return accountOut;
    }

    @Override
    public List<Account> getAllAccount() {
        List<Account> accounts;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            accounts = entityManager.createQuery("SELECT Account FROM Account ", Account.class).getResultList();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }

        return accounts;
    }

}
