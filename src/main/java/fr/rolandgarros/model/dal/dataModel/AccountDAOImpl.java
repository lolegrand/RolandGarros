package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.model.Account;
import fr.rolandgarros.model.dal.AccountDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AccountDAOImpl implements AccountDAO {
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;



    @Override
    public Account findAccountByLoginPassword(String login, String password) {

        Account accounts;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            accounts = entityManager.createQuery("FROM Account a WHERE a.login = ?1 AND a.password = ?2", Account.class)
                    .setParameter(1,login).setParameter(2,password).getSingleResult();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }

        return accounts;
    }

    @Override
    public void createAccount(Account account) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
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
            entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.remove(account);
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }

}
