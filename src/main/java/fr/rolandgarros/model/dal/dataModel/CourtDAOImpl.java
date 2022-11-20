package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.JPAService;
import fr.rolandgarros.model.Court;
import fr.rolandgarros.model.dal.CourtDAO;


import java.util.List;

public class CourtDAOImpl implements CourtDAO {
    @Override
    public void createCourt(Court court) {
        JPAService jpaService = JPAService.getInstance();

        try {
            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(court);
                return null;
            });
        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public void deleteCourt(Court court) {
        JPAService jpaService = JPAService.getInstance();
        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.remove(entityManager.merge(court));
                return null;
            });
        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public Court getCourtById(int id) {

        JPAService jpaService = JPAService.getInstance();

        Court court;
        try {
            court =  jpaService.runInTransaction(entityManager -> entityManager.find(Court.class, id));
        } finally {
            jpaService.shutdown();
        }
        return court;
    }

    @Override
    public List<Court> getAllCourt() {
        JPAService jpaService = JPAService.getInstance();
        List<Court> courts;
        try {
            courts =  jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Court", Court.class).getResultList());
        } finally {
            jpaService.shutdown();
        }
        return courts;
    }
}
