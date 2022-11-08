package fr.rolandgarros.services;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.dal.CourtDAO;
import fr.rolandgarros.model.dal.MatchDAO;
import fr.rolandgarros.model.dal.stub.CourtDAOMock;
import fr.rolandgarros.model.dal.stub.MatchDAOMock;

import java.util.List;

public class CourtService {
    private final CourtDAO courtDAO = new CourtDAOMock();
    //private final CourtDAO courtDAO = new CourtDAOImpl();

    void createCourt(Court court){
        courtDAO.createCourt(court);
    }

    List<Court> getAllCourt(){
        return courtDAO.getAllCourt();
    }
    Court getCourtById(int id){
        return courtDAO.getCourtById(id);
    }


    void deleteCourt(Court court){
        courtDAO.deleteCourt(court);
    }
}
