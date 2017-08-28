package com.gpotato.study;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by hirang on 2017. 8. 28..
 */
public class EntityMappingMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpastudy");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        try {
            tx.begin();
            //logic
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        finally {
            em.close();
        }
        emf.close();
    }
}
