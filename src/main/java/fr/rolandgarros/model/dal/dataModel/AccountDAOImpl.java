package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.JPAService;
import fr.rolandgarros.model.Account;
import fr.rolandgarros.model.dal.AccountDAO;


public class AccountDAOImpl implements AccountDAO {

    @Override
    public Account findAccountByLoginPassword(String login, String password) {

        JPAService jpaService = JPAService.getInstance();

        Account account;
        try {

            account =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Account a WHERE a.login = :login", Account.class)
                    .setParameter("login",login).getSingleResult());

        } finally {
            jpaService.shutdown();
        }

        if (account == null || !account.verifyHash(password)) {
            return null;
        }else {
            return account;
        }
    }

    @Override
    public void createAccount(Account account) {

        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(account);
                return null;
            });

        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public void updateAccount(Account account) {
        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(entityManager.merge(account));
                return null;
            });

        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public void deleteAccount(Account account) {
        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.remove(entityManager.merge(account));
                return null;
            });

        } finally {
            jpaService.shutdown();
        }
    }

}
