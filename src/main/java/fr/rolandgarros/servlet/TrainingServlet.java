package fr.rolandgarros.servlet;

import fr.rolandgarros.model.Role;
import fr.rolandgarros.model.Training;
import fr.rolandgarros.services.TrainingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class TrainingServlet extends HttpServlet {

    private final TrainingService service = new TrainingService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
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

        List<Training> trainings = service.getAllTraining();

        req.getSession().setAttribute("role", Role.ADMINISTRATOR);
        req.setAttribute("trainings", trainings);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
