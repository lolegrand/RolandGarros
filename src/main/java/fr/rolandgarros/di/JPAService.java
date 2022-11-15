package fr.rolandgarros.di;

import jakarta.persistence.*;

import java.util.function.Function;

public class JPAService {

    private static JPAService instance;
    private final EntityManagerFactory entityManagerFactory;

    private JPAService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("RolandGarros");
    }

    public static synchronized JPAService getInstance() {
        return instance == null ? instance = new JPAService() : instance;
    }

    public void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            instance = null;
        }
    }

    public <T> T runInTransaction(Function<EntityManager, T> function) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        boolean success = false;
        try {
            T returnValue = function.apply(entityManager);
            success = true;
            return returnValue;

        }catch (NoResultException e){
            return null;
        }finally {
            if (success) {
                transaction.commit();
            } else {
                transaction.rollback();
            }
            entityManager.close();
        }
    }
}