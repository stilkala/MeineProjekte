package de.hda.fbi.db2.stud.impl;

import de.hda.fbi.db2.api.Lab01Data;
import de.hda.fbi.db2.api.Lab02EntityManager;
import de.hda.fbi.db2.stud.entity.Category;
import de.hda.fbi.db2.stud.entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Lab02 extends Lab02EntityManager {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("fbi-postgresPU");

    @Override
    public void persistData() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List<Category> categories = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for (Object o:lab01Data.getCategories()
        ) {
            categories.add((Category) o);
        }

        for (Object o:lab01Data.getQuestions()
        ) {
            questions.add((Question) o);
        }

        try {
            for (Question q: questions) {
                em.persist(q);
            }
            for (Category c: categories) {
                em.persist(c);
            }

            tx.commit();


        } catch (RuntimeException e) {
            {
                if (tx.isActive()) {
                    tx.rollback();
                }
            }
            throw e;

        } finally {
            em.close();
        }

    }

    @Override
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
