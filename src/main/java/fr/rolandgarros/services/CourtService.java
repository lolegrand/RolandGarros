package fr.rolandgarros.services;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.dal.CourtDAO;
import fr.rolandgarros.model.dal.MatchDAO;
import fr.rolandgarros.model.dal.dataModel.CourtDAOImpl;
import fr.rolandgarros.model.dal.stub.CourtDAOMock;
import fr.rolandgarros.model.dal.stub.MatchDAOMock;
import fr.rolandgarros.model.dal.stub.CourtDAOMock;

import java.util.List;

public class CourtService {
    private final CourtDAO courtDAO = new CourtDAOImpl();

    public void createCourt(Court court){
        courtDAO.createCourt(court);
    }

    public List<Court> getAllCourt(){
        return courtDAO.getAllCourt();
    }
    public Court getCourtById(int id){
        return courtDAO.getCourtById(id);
    }


    public void deleteCourt(Court court){
        courtDAO.deleteCourt(court);
    }
}
