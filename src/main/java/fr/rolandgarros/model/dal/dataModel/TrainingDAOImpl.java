package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.JPAService;
import fr.rolandgarros.model.Training;
import fr.rolandgarros.model.dal.TrainingDAO;


import java.util.List;

public class TrainingDAOImpl implements TrainingDAO {

    @Override
    public void createTrainingDemand(Training training) {

        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(training);
                return null;
            });

        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public void completeTrainingDemand(Training training) {
        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.merge(training);
                return null;
            });

        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public void deleteTrainingDemand(Training training) {
        JPAService jpaService = JPAService.getInstance();

        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.remove(entityManager.merge(training));
                return null;
            });

        } finally {
            jpaService.shutdown();
        }

    }

    @Override
    public List<Training> getAllTraining() {

        JPAService jpaService = JPAService.getInstance();

        List<Training> trainings;
        try {

            trainings =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Training", Training.class).getResultList());


        } finally {
            jpaService.shutdown();
        }

        return trainings;
    }

    @Override
    public Training getTrainingById(int trainingId) {

        JPAService jpaService = JPAService.getInstance();

        Training training;
        try {

            training =  jpaService.runInTransaction(entityManager -> entityManager.find(Training.class, trainingId));


        } finally {
            jpaService.shutdown();
        }

        return training;
    }
}
