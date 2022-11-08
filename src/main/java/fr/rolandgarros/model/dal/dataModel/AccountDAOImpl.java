package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.model.Account;
import fr.rolandgarros.model.dal.AccountDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AccountDAOImpl implements AccountDAO {
    private  EntityManagerFactory entityManagerFactory;
    private  EntityManager entityManager;
    private final String persistenceUnitName = "RolandGarros";

    @Override
    public Account findAccountByLoginPassword(String login, String password) {

        Account account;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            account = entityManager.createQuery("FROM Account a WHERE a.login = :login", Account.class)
                    .setParameter("login",login).getSingleResult();
        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }

        if (account == null || !account.verifyHash(password)) {
            return null;
        }else {
            return account;
        }
    }

    @Override
    public void createAccount(Account account) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            account = entityManager.merge(account);
            entityManager.persist(account);
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }

    @Override
    public void updateAccount(Account account) {
        createAccount(account);
    }

    @Override
    public void deleteAccount(Account account) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            account = entityManager.merge(account);
            entityManager.remove(account);
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }

}
