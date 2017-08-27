package com.gpotato.db;

import com.gpotato.entities.Members;
import com.gpotato.entities.Teams;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by hirang on 2017. 8. 27..
 */
public class JpaMain1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try
        {
            tx.begin();
            bizlogic(em);
            tx.commit();
        } catch (Exception e)
        {
            tx.rollback();
        }
        finally
        {
            em.close();
        }
        emf.close();
    }

    public static void bizlogic(EntityManager em){
        Teams team = new Teams();
        team.setTeamname("박희랑팀");
        em.persist(team);

        Teams team1 = new Teams("박시후팀");
        em.persist(team1);

        Members mem = new Members();
        mem.setUsername("박희랑");
        mem.setTeam(team);
        em.persist(mem);

        Members mem1 = new Members();
        mem1.setUsername("박시후");
        mem1.setTeam(team1);
        em.persist(mem1);

        System.out.println("count : " + team1.getMembers().size());
    }
}
