package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.model.Training;
import fr.rolandgarros.model.dal.TrainingDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Persistence;

import java.util.List;

public class TrainingDAOImpl implements TrainingDAO {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private final String persistenceUnitName = "RolandGarros";
    @Override
    public void createTrainingDemand(Training training) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            training = entityManager.merge(training);
            entityManager.persist(training);
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }

    @Override
    public void completeTrainingDemand(Training training) {
        createTrainingDemand(training);
    }

    @Override
    public void deleteTrainingDemand(Training training) {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            training = entityManager.merge(training);
            entityManager.remove(training);
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }

    }

    @Override
    public List<Training> getAllTraining() {
        List<Training> trainings;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            trainings = entityManager.createQuery("FROM Training", Training.class).getResultList();
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }

        return trainings;
    }

    @Override
    public Training getTrainingById(int trainingId) {
        Training trainingById;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            trainingById = entityManager.createQuery("SELECT t FROM Training t WHERE t.idT = :id", Training.class).setParameter("id",trainingId).getSingleResult();
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }

        return trainingById;
    }
}
