package com.gpotato.study;

import com.gpotato.entities.ConsistenceMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by hirang on 2017. 8. 27..
 */
public class ConsistenceMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpastudy");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        PersisType eType = PersisType.CLEAR;

        try {
            tx.begin();
            switch (eType){
                case PERSIST:
                    execPersist(em);
                    break;
                case FIND:
                    execFind(em);
                    break;
                case REMOVE:
                    execRemove(em);
                    break;
                case DETACH:
                    execDetach(em);
                    break;
                case MERGE:
                    execDetachMerge(em);
                    break;
                case CLEAR:
                    execClear(em);
                    break;
            }

            tx.commit(); //flush가 자동 실행
        } catch (Exception e) {
            tx.rollback();
        }
        finally {
            em.close();
        }
        emf.close();
    }

    public static void execPersist(EntityManager em)
    {
        ConsistenceMember mem = new ConsistenceMember();
        mem.setId("hirang");
        mem.setUsername("박희랑");
        mem.setAge(20);
        em.persist(mem);

        ConsistenceMember mem1 = new ConsistenceMember();
        mem1.setId("danhu");
        mem1.setUsername("박단후");
        mem1.setAge(7);
        em.persist(mem1);
    }

    public static void execFind(EntityManager em){
        execPersist(em);
        //영속엔티티의 영속성 보장
        ConsistenceMember mem = em.find(ConsistenceMember.class, "hirang"); //1차 캐쉬 조회, 없으면 DB에서 조회, 그래도 없으면 null
        ConsistenceMember mem1 = em.find(ConsistenceMember.class, "hirang");
        System.out.println("mem==mem1 : " + (mem==mem1));

        mem.setUsername("박시후");
    }

    public static void execRemove(EntityManager em){
        execPersist(em);
        //JPQL 실행 시 flush 자동 실행
        List<ConsistenceMember> memList = em.createQuery("select m from ConsistenceMember m", ConsistenceMember.class).getResultList();
        System.out.println("ConsistenceMembers.size=" + memList.size());
        em.remove(memList.get(0));
    }

    public static ConsistenceMember execDetach(EntityManager em){
        execPersist(em);
        em.flush();
        ConsistenceMember mem1 = em.find(ConsistenceMember.class,"danhu" );
        mem1.setAge(10000);
        ConsistenceMember mem = em.find(ConsistenceMember.class, "hirang");
        em.detach(mem);
        mem.setAge(1000);
        return mem;
    }

    public static void execDetachMerge(EntityManager em){
        ConsistenceMember mem = execDetach(em);
        //mem.setAge(500);
        em.merge(mem);
    }

    public static void execClear(EntityManager em){
        execPersist(em);
        em.flush();
        em.clear();
        ConsistenceMember mem = em.find(ConsistenceMember.class, "hirang");
        System.out.println("ConsistenceMember ID : " + mem.getId());
        mem.setAge(2000);
        em.merge(mem);
    }

    enum PersisType{
        PERSIST,
        FIND,
        REMOVE,
        DETACH,
        MERGE,
        CLEAR
    }

}
