package fr.rolandgarros.model.dal.stub;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Training;
import fr.rolandgarros.model.dal.CourtDAO;
import fr.rolandgarros.model.dal.PersonDAO;
import fr.rolandgarros.model.dal.TrainingDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TrainingDAOMock implements TrainingDAO {

    private final List<Training> trainings = new ArrayList<>();

    public TrainingDAOMock() {
        PersonDAO personDAO = new PersonDAOMock();
        CourtDAO courtDAO = new CourtDAOMock();
        List<Court> courts = courtDAO.getAllCourt();
        List<Person> persons = personDAO.getAllPerson();
        trainings.add(
                new Training(
                        Date.valueOf("2022-01-14"),
                        persons.get(0),
                        courts.get(1)
                )
        );
        trainings.add(
                new Training(
                        Date.valueOf("2022-01-15"),
                        persons.get(0),
                        courts.get(1)
                )
        );
        trainings.add(
                new Training(
                        Date.valueOf("2022-01-16"),
                        persons.get(2),
                        courts.get(3)
                )
        );
        trainings.add(
                new Training(
                        Date.valueOf("2022-01-13"),
                        persons.get(2),
                        courts.get(3)
                ) {{
                    setValidated(true);
                }}
        );
    }

    @Override
    public void createTrainingDemand(Training training) {
        trainings.add(training);
    }

    @Override
    public void completeTrainingDemand(Training training) {

    }

    @Override
    public void deleteTrainingDemand(Training training) {
        trainings.add(training);
    }

    @Override
    public List<Training> getAllTraining() {
        return trainings;
    }
}
