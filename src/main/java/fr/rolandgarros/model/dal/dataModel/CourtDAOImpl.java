package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.dal.CourtDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CourtDAOImpl implements CourtDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private final String persistenceUnitName = "RolandGarros";

    @Override
    public void createCourt(Court court) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            court = entityManager.merge(court);
            entityManager.persist(court);
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }

    @Override
    public List<Court> getAllCourt() {
        List<Court> courts;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            courts = entityManager.createQuery("FROM Court", Court.class).getResultList();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
        return courts;
    }

    @Override
    public void deleteCourt(Court court) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            court = entityManager.merge(court);
            entityManager.remove(court);
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }

    @Override
    public Court getCourtById(int id) {
        Court court;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            court = entityManager.find(Court.class, id);

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
        return court;
    }
}
