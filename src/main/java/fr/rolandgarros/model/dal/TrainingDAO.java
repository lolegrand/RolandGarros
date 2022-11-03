package fr.rolandgarros.model.dal;

import fr.rolandgarros.model.Training;

import java.util.List;

public interface TrainingDAO {
    void createTrainingDemand(Training training);

    void completeTrainingDemand(Training training);

    void deleteTrainingDemand(Training training);

    List<Training> getAllTraining();

    Training getTrainingById(int trainingId);
}
