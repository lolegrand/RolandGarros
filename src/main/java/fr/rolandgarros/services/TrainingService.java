package fr.rolandgarros.services;

import fr.rolandgarros.model.Training;
import fr.rolandgarros.model.dal.TrainingDAO;
import fr.rolandgarros.model.dal.stub.TrainingDAOMock;

import java.util.List;

public class TrainingService {

    private final TrainingDAO trainingDAO = new TrainingDAOMock();
    //private final TrainingDAO trainingDAO = new TrainingDAOImpl();

    public List<Training> getAllTraining() {
        return trainingDAO.getAllTraining();
    }

    public void createTrainingDemand(Training training) {
        trainingDAO.createTrainingDemand(training);
    }

    public void removeTrainingDemand(Training training) {
        trainingDAO.deleteTrainingDemand(training);
    }

    public void completeTrainingDemand(Training training) {
        trainingDAO.completeTrainingDemand(training);
    }

    public Training getTrainingById(int trainingId) {
        return trainingDAO.getTrainingById(trainingId);
    }
}
