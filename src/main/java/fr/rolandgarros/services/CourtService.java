package fr.rolandgarros.services;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.dal.CourtDAO;
import fr.rolandgarros.model.dal.stub.CourtDAOMock;

import java.util.List;

public class CourtService {

    private final CourtDAO courtDAO = new CourtDAOMock();

    public List<Court> getAllCourt() {
        return courtDAO.getAllCourt();
    }

    public void create(Court court) {
        courtDAO.createCourt(court);
    }

    public void delete(Court court) { courtDAO.deleteCourt(court); }

    public Court getCourtById(int courtId) {
        return courtDAO.getCourtById(courtId);
    }

}
