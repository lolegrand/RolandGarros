package fr.rolandgarros.servlet;


import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.Person;
import fr.rolandgarros.model.Training;
import fr.rolandgarros.services.CourtService;
import fr.rolandgarros.services.PersonService;
import fr.rolandgarros.services.TrainingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

public class TrainingServlet extends HttpServlet {

    private final TrainingService service = new TrainingService();
    private final CourtService courtService = new CourtService();
    private final PersonService personService = new PersonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            doProcess(req, resp);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            doProcess(req, resp);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ParseException {
        String page = "/ViewTraining/Trainings.jsp";

        String demandState = req.getParameter("state");

        if (demandState != null) {
            if (demandState.equals("Accepter")) {
                int trainingId = Integer.parseInt(req.getParameter("training"));
                Training training = service.getTrainingById(trainingId) ;
                training.setValidated(true);
                service.completeTrainingDemand(training);
            }

            if (demandState.equals("Refuser")) {
                int trainingId = Integer.parseInt(req.getParameter("training"));
                Training training = service.getTrainingById(trainingId) ;
                training.setValidated(false);
                service.completeTrainingDemand(training);
            }
        }

        List<Court> courts = courtService.getAllCourt();
        req.setAttribute("courts", courts);

        List<Person> trainers = personService.getAllPerson();
        req.setAttribute("trainers", trainers);

        // Handle training creation demand

        boolean createTraining = req.getParameter("submitFormCreateTraining") != null;
        if (createTraining) {
            String error = "Success";

            int idCourt = Integer.parseInt(req.getParameter("selectCourt"));
            int idTrainer = Integer.parseInt(req.getParameter("selectTrainer"));

            String date = req.getParameter("DateSchedule");
            String time = req.getParameter("TimeSchedule");

            String schedule = date.toString()+" "+time.toString()+":00.0";

            if (schedule == null) {
                error = "Erreur : le terrain est déjà reservé";
            }

            Person trainer = personService.getPersonById(idTrainer);
            Court court = courtService.getCourtById(idCourt);
            if (trainer == null || court == null) {
                error = "Error lors de la saisie d'un champs";
            }

            if (error.equals("Success")) {
                Training newTraining = new Training(Timestamp.valueOf(schedule), trainer, court);

                try {
                    service.createTrainingDemand(newTraining);
                } catch (Exception e) {
                    error = "Erreur l'ors de l'enregistrement de votre entrainement.";
                }
            }

            req.setAttribute("reqCreationError", error);

        }

        List<Training> trainings = service.getAllTraining();
        req.setAttribute("trainings", trainings);


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
