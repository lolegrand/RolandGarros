package fr.rolandgarros.model.dal.stub;

import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.dal.CourtDAO;

import java.util.ArrayList;
import java.util.List;

public class CourtDAOMock implements CourtDAO {

    private final List<Court> courts = new ArrayList<Court>() {{
        add(new Court("Court 1"));
        add(new Court("Court 2"));
        add(new Court("Court 3"));
        add(new Court("Court 4"));
    }};

    @Override
    public void createCourt(Court court) {
        if (courts.contains(court)) {
            return;
        }
        courts.add(court);
    }

    @Override
    public List<Court> getAllCourt() {
        return courts;
    }

    @Override
    public void deleteCourt(Court court) {
        courts.remove(court);
    }
}
