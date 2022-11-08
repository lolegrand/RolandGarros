package fr.rolandgarros.model.dal;

import fr.rolandgarros.model.Court;

import java.util.List;

public interface CourtDAO {

    void createCourt(Court court);

    List<Court> getAllCourt();

    void deleteCourt(Court court);

    Court getCourtById(int id);
}
