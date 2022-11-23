package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.PersistenceManager;
import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.dal.CourtDAO;
import java.util.List;

public class CourtDAOImpl implements CourtDAO {
    @Override
    public void createCourt(Court court) {
            PersistenceManager.runInTransaction(entityManager -> {
                entityManager.persist(court);
                return null;
            });
    }
    @Override
    public void deleteCourt(Court court) {
            PersistenceManager.runInTransaction(entityManager -> {
                entityManager.remove(entityManager.merge(court));
                return null;
            });
    }
    @Override
    public Court getCourtById(int id) {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.find(Court.class, id));
    }
    @Override
    public List<Court> getAllCourt() {
        return PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Court", Court.class).getResultList());
    }
}
