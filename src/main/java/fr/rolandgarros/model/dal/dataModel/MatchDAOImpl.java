package fr.rolandgarros.model.dal.dataModel;
import fr.rolandgarros.di.JPAService;
import fr.rolandgarros.model.*;
import fr.rolandgarros.model.Double;
import fr.rolandgarros.model.dal.MatchDAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchDAOImpl implements MatchDAO {

    @Override
    public Match getMatch(Court court, Timestamp start) {
        JPAService jpaService = JPAService.getInstance();
        Object match;
        try {
            Object matchD = jpaService.runInTransaction(entityManager -> entityManager.createQuery("SELECT m FROM Double m WHERE m.court = :court AND m.startDate = :start", Double.class)
                        .setParameter("court", court)
                        .setParameter("start", start)
                        .getSingleResult());
            match = matchD == null ? jpaService.runInTransaction(entityManager -> entityManager.createQuery("SELECT m FROM Single m WHERE m.court = :court AND m.startDate = :start", Single.class)
                        .setParameter("court", court)
                        .setParameter("start", start)
                        .getSingleResult()) : matchD;
        }finally {
            jpaService.shutdown();
        }

        return (Match) match;

    }

    @Override
    public void createMatch(Match match) {
        JPAService jpaService = JPAService.getInstance();
        try {
            jpaService.runInTransaction(entityManager -> {
                if (match instanceof Double) {
                    entityManager.persist((Double) match);
                } else if (match instanceof Single) {
                    entityManager.persist((Single) match);
                }
                return null;
            });
        }finally {
            jpaService.shutdown();
        }
    }

    @Override
    public void deleteMatch(Match match) {
        JPAService jpaService = JPAService.getInstance();
        try {
            jpaService.runInTransaction(entityManager -> {
                if (match instanceof Double) {
                    entityManager.remove(entityManager.merge((Double) match));
                } else if (match instanceof Single) {
                    entityManager.remove(entityManager.merge((Single) match));
                }
                return null;
            });
        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public void modifyMatch(Match match) {
        JPAService jpaService = JPAService.getInstance();
        try {
            jpaService.runInTransaction(entityManager -> {
                if (match instanceof Double) {
                    entityManager.merge((Double) match);
                } else if (match instanceof Single) {
                    entityManager.merge((Single) match);
                }
                return null;
            });
        } finally {
            jpaService.shutdown();
        }
    }

    @Override
    public Match getMatchById(int id) {
        JPAService jpaService = JPAService.getInstance();
        Object match;
        try {
            Object matchD = jpaService.runInTransaction(entityManager -> entityManager.find(Double.class, id));
            match = matchD == null ? jpaService.runInTransaction(entityManager -> entityManager.find(Single.class,id)) : matchD;
        }finally {
            jpaService.shutdown();
        }

        return (Match) match;
    }

    @Override
    public List<Match> getAllMatches() {
        JPAService jpaService = JPAService.getInstance();
        ArrayList<Object> matches = new ArrayList<>();
        List<Double> doubles;
        List<Single> singles;
        try {
            doubles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Double", Double.class).getResultList());
            singles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Single", Single.class).getResultList());

            matches.addAll(doubles);
            matches.addAll(singles);
        }finally {
            jpaService.shutdown();
        }
        return (List<Match>) (List<?>) matches;

    }

    @Override
    public List<Match> getMatchesToCome() {
        JPAService jpaService = JPAService.getInstance();
        ArrayList<Object> matches = new ArrayList<>();
        List<Double> doubles;
        List<Single> singles;
        try {
            doubles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Double m WHERE m.startDate > CURRENT_TIMESTAMP", Double.class).getResultList());
            singles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Single m WHERE m.startDate > CURRENT_TIMESTAMP", Single.class).getResultList());

            matches.addAll(doubles);
            matches.addAll(singles);
        }finally {
            jpaService.shutdown();
        }
        return (List<Match>) (List<?>) matches;
    }

    @Override
    public List<Match> getMatchesPast() {
        JPAService jpaService = JPAService.getInstance();
        ArrayList<Object> matches = new ArrayList<>();
        List<Double> doubles;
        List<Single> singles;
        try {
            doubles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Double m WHERE m.startDate < CURRENT_TIMESTAMP", Double.class).getResultList());
            singles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Single m WHERE m.startDate < CURRENT_TIMESTAMP", Single.class).getResultList());

            matches.addAll(doubles);
            matches.addAll(singles);
        }finally {
            jpaService.shutdown();
        }
        return (List<Match>) (List<?>) matches;
    }

    @Override
    public List<Match> getSimpleMen() {
        JPAService jpaService = JPAService.getInstance();
        List<Single> singles;
        try {
            singles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender", Single.class)
                    .setParameter("gender", Gender.MALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }

       return (List<Match>) (List<?>) singles;
    }

    @Override
    public List<Match> getDoubleMen() {
        JPAService jpaService = JPAService.getInstance();
        List<Double> doubles;
        try {
            doubles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender", Double.class)
                    .setParameter("gender", Gender.MALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }
        return (List<Match>) (List<?>) doubles;
    }

    @Override
    public List<Match> getSimpleWomen() {
        JPAService jpaService = JPAService.getInstance();
        List<Single> singles;
        try {
            singles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender", Single.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }

        return (List<Match>) (List<?>) singles;
    }

    @Override
    public List<Match> getDoubleWomen() {
        JPAService jpaService = JPAService.getInstance();
        List<Double> doubles;
        try {
            doubles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender", Double.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }
        return (List<Match>) (List<?>) doubles;
    }

    @Override
    public List<Match> getSimpleMenToCome() {
        JPAService jpaService = JPAService.getInstance();
        List<Single> singles;
        try {
            singles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender AND ms.startDate > CURRENT_TIMESTAMP", Single.class)
                    .setParameter("gender", Gender.MALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }

        return (List<Match>) (List<?>) singles;
    }

    @Override
    public List<Match> getDoubleMenToCome() {
        JPAService jpaService = JPAService.getInstance();
        List<Double> doubles;
        try {
            doubles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender AND md.startDate > CURRENT_TIMESTAMP", Double.class)
                    .setParameter("gender", Gender.MALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }
        return (List<Match>) (List<?>) doubles;
    }

    @Override
    public List<Match> getSimpleWomenToCome() {
        JPAService jpaService = JPAService.getInstance();
        List<Single> singles;
        try {
            singles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender AND ms.startDate > CURRENT_TIMESTAMP", Single.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }

        return (List<Match>) (List<?>) singles;
    }

    @Override
    public List<Match> getDoubleWomenToCome() {
        JPAService jpaService = JPAService.getInstance();
        List<Double> doubles;
        try {
            doubles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender AND md.startDate > CURRENT_TIMESTAMP", Double.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }
        return (List<Match>) (List<?>) doubles;
    }

    @Override
    public List<Match> getSimpleMenPast() {
        JPAService jpaService = JPAService.getInstance();
        List<Single> singles;
        try {
            singles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender AND ms.startDate < CURRENT_TIMESTAMP", Single.class)
                    .setParameter("gender", Gender.MALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }

        return (List<Match>) (List<?>) singles;
    }

    @Override
    public List<Match> getDoubleMenPast() {
        JPAService jpaService = JPAService.getInstance();
        List<Double> doubles;
        try {
            doubles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender AND md.startDate < CURRENT_TIMESTAMP", Double.class)
                    .setParameter("gender", Gender.MALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }
        return (List<Match>) (List<?>) doubles;
    }

    @Override
    public List<Match> getSimpleWomenPast() {
        JPAService jpaService = JPAService.getInstance();
        List<Single> singles;
        try {
            singles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Single ms WHERE ms.gender =:gender AND ms.startDate < CURRENT_TIMESTAMP", Single.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }

        return (List<Match>) (List<?>) singles;
    }

    @Override
    public List<Match> getDoubleWomenPast() {
        JPAService jpaService = JPAService.getInstance();
        List<Double> doubles;
        try {
            doubles = jpaService.runInTransaction(entityManager -> entityManager.createQuery("FROM Double md WHERE md.gender =:gender AND md.startDate < CURRENT_TIMESTAMP", Double.class)
                    .setParameter("gender", Gender.FEMALE)
                    .getResultList());
        }finally {
            jpaService.shutdown();
        }
        return (List<Match>) (List<?>) doubles;
    }
}
