package fr.rolandgarros.di;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import org.hibernate.Session;

import java.util.function.Function;

public class PersistenceManager {
    private static EntityManagerFactory factory;
    public static Session getSession() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("RolandGarros");
        }

        EntityManager entityManager = factory.createEntityManager();

        return entityManager.unwrap(Session.class);
    }
    public static Session beginTransaction() {
        Session hibernateSession = getSession();
        hibernateSession.beginTransaction();
        return hibernateSession;
    }
    public static  <T> T runInTransaction(Function<Session, T> function) {
        Session transaction = beginTransaction();

        boolean success = false;
        try {
            T returnValue = function.apply(transaction);
            success = true;
            return returnValue;

        }catch (NoResultException e){
            return null;
        }finally {
            if (success) {
                commitTransaction(transaction);
            } else {
                rollbackTransaction(transaction);
            }
            closeSession(transaction);
        }
    }
    public static void commitTransaction(Session s) {
        s.getTransaction().commit();
    }
    public static void rollbackTransaction(Session s) {
        s.getTransaction().rollback();
    }
    public static void closeSession(Session s) {
        s.close();
    }

}