package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.PersistenceManager;
import fr.rolandgarros.model.Training;
import fr.rolandgarros.model.dal.TrainingDAO;
import java.util.List;

public class TrainingDAOImpl implements TrainingDAO {
    @Override
    public void createTrainingDemand(Training training) {
        PersistenceManager.runInTransaction(entityManager -> {
                entityManager.persist(training);
                return null;
            });
    }
    @Override
    public void completeTrainingDemand(Training training) {
        PersistenceManager.runInTransaction(entityManager -> {
                entityManager.merge(training);
                return null;
            });
    }
    @Override
    public void deleteTrainingDemand(Training training) {
        PersistenceManager.runInTransaction(entityManager -> {
                entityManager.remove(entityManager.merge(training));
                return null;
            });
    }
    @Override
    public List<Training> getAllTraining() {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Training", Training.class).getResultList());
    }
    @Override
    public Training getTrainingById(int trainingId) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.find(Training.class, trainingId));
    }
}
