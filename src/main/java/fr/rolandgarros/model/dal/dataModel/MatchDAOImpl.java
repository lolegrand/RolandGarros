package fr.rolandgarros.model.dal.dataModel;

import fr.rolandgarros.di.PersistenceManager;
import fr.rolandgarros.model.*;
import fr.rolandgarros.model.Double;
import fr.rolandgarros.model.dal.MatchDAO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MatchDAOImpl implements MatchDAO {
    @Override
    public Match getMatch(Court court, Timestamp start) {
        Object match;
        
        Object matchD = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("SELECT m FROM Double m WHERE m.court = :court AND m.startDate = :start", Double.class)
                    .setParameter("court", court)
                    .setParameter("start", start)
                    .getSingleResult());
        
        match = matchD == null ? PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("SELECT m FROM Single m WHERE m.court = :court AND m.startDate = :start", Single.class)
                    .setParameter("court", court)
                    .setParameter("start", start)
                    .getSingleResult()) : matchD;

        return (Match) match;
    }
    @Override
    public void createMatch(Match match) {
        PersistenceManager.runInTransaction(entityManager -> {
            if (match instanceof Double) {
                entityManager.merge((Double) match);
            } else if (match instanceof Single) {
                entityManager.merge((Single) match);
            }
            return null;
        });
    }
    @Override
    public void deleteMatch(Match match) {
        PersistenceManager.runInTransaction(entityManager -> {
            if (match instanceof Double) {
                entityManager.remove(entityManager.merge((Double) match));
            } else if (match instanceof Single) {
                entityManager.remove(entityManager.merge((Single) match));
            }
            return null;
        });
    }
    @Override
    public void modifyMatch(Match match) {
        PersistenceManager.runInTransaction(entityManager -> {
            if (match instanceof Double) {
                entityManager.merge((Double) match);
            } else if (match instanceof Single) {
                entityManager.merge((Single) match);
            }
            return null;
        });
    }
    @Override
    public Match getMatchById(int id) {
        Object match;

        Object matchD = PersistenceManager.runInTransaction(entityManager -> entityManager.find(Double.class, id));
        match = matchD == null ? PersistenceManager.runInTransaction(entityManager -> entityManager.find(Single.class,id)) : matchD;

        return (Match) match;
    }
    @Override
    public List<Match> getAllMatches() {
        ArrayList<Object> matches = new ArrayList<>();
        List<Double> doubles;
        List<Single> singles;
        
        doubles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Double", Double.class).getResultList());
        singles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Single", Single.class).getResultList());

        matches.addAll(doubles);
        matches.addAll(singles);
        
        return (List<Match>) (List<?>) matches;
    }
    @Override
    public List<Match> getMatchesToCome() {
        ArrayList<Object> matches = new ArrayList<>();
        List<Double> doubles;
        List<Single> singles;

        doubles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Double m WHERE m.startDate > CURRENT_TIMESTAMP", Double.class).getResultList());
        singles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Single m WHERE m.startDate > CURRENT_TIMESTAMP", Single.class).getResultList());

        matches.addAll(doubles);
        matches.addAll(singles);
            
        return (List<Match>) (List<?>) matches;
    }
    @Override
    public List<Match> getMatchesPast() {
        ArrayList<Object> matches = new ArrayList<>();
        List<Double> doubles;
        List<Single> singles;

        doubles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Double m WHERE m.startDate < CURRENT_TIMESTAMP", Double.class).getResultList());
        singles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Single m WHERE m.startDate < CURRENT_TIMESTAMP", Single.class).getResultList());

        matches.addAll(doubles);
        matches.addAll(singles);

        return (List<Match>) (List<?>) matches;
    }
    @Override
    public List<Match> getSimpleMen() {
        List<Single> singles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender", Single.class)
                .setParameter("gender", Gender.MALE)
                .getResultList());

       return (List<Match>) (List<?>) singles;
    }
    @Override
    public List<Match> getDoubleMen() {
        List<Double> doubles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender", Double.class)
                    .setParameter("gender", Gender.MALE)
                    .getResultList());

        return (List<Match>) (List<?>) doubles;
    }
    @Override
    public List<Match> getSimpleWomen() {
        List<Single> singles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender", Single.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());

        return (List<Match>) (List<?>) singles;
    }
    @Override
    public List<Match> getDoubleWomen() {
        
        List<Double> doubles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender", Double.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());
        return (List<Match>) (List<?>) doubles;
    }
    @Override
    public List<Match> getSimpleMenToCome() {
        List<Single> singles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender AND ms.startDate > CURRENT_TIMESTAMP", Single.class)
                    .setParameter("gender", Gender.MALE)
                    .getResultList());

        return (List<Match>) (List<?>) singles;
    }
    @Override
    public List<Match> getDoubleMenToCome() {
        List<Double> doubles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender AND md.startDate > CURRENT_TIMESTAMP", Double.class)
                    .setParameter("gender", Gender.MALE)
                    .getResultList());
        return (List<Match>) (List<?>) doubles;
    }
    @Override
    public List<Match> getSimpleWomenToCome() {
        List<Single> singles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender AND ms.startDate > CURRENT_TIMESTAMP", Single.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());

        return (List<Match>) (List<?>) singles;
    }
    @Override
    public List<Match> getDoubleWomenToCome() {
        List<Double> doubles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender AND md.startDate > CURRENT_TIMESTAMP", Double.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());
        return (List<Match>) (List<?>) doubles;
    }
    @Override
    public List<Match> getSimpleMenPast() {
        List<Single> singles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender AND ms.startDate < CURRENT_TIMESTAMP", Single.class)
                    .setParameter("gender", Gender.MALE)
                    .getResultList());

        return (List<Match>) (List<?>) singles;
    }

    @Override
    public List<Match> getDoubleMenPast() {
        List<Double> doubles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender AND md.startDate < CURRENT_TIMESTAMP", Double.class)
                    .setParameter("gender", Gender.MALE)
                    .getResultList());
        return (List<Match>) (List<?>) doubles;
    }
    @Override
    public List<Match> getSimpleWomenPast() {
        List<Single> singles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender AND ms.startDate < CURRENT_TIMESTAMP", Single.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());

        return (List<Match>) (List<?>) singles;
    }
    @Override
    public List<Match> getDoubleWomenPast() {
        List<Double> doubles = PersistenceManager.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender AND md.startDate < CURRENT_TIMESTAMP", Double.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());
        return (List<Match>) (List<?>) doubles;
    }
}
