package com.gpotato.study;

import com.gpotato.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by hirang on 2017-08-28.
 */
public class MappingMain
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpastudy");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        DirectionType dType = DirectionType.BOTH_DIRECTION;
        MappingType mType = MappingType.MANY_TO_MANY;
        try {
            tx.begin();

            switch (dType) {
                case ONE_DIRECTION:
                    if(mType == MappingType.MANY_TO_ONE )
                        execOneDirection(em);
                    else
                        execOneDirectionMany(em);
                    break;
                case BOTH_DIRECTION:
                    if(mType == MappingType.MANY_TO_ONE )
                        execBothDirection(em);
                    else
                        execBothDirectionMany(em);
                    break;
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        finally {
            em.close();
        }
        emf.close();
    }

    public static void execOneDirection(EntityManager em){
        OneDirectionTeam team1 = new OneDirectionTeam("team1", "팀1");
        em.persist(team1);

        OneDirectionMember member1 = new OneDirectionMember("member1", "회원1");
        member1.setTeam(team1);

        em.persist(member1);

        OneDirectionMember member2 = new OneDirectionMember("member2", "회원2");
        member2.setTeam(team1);
        em.persist(member2);

        queryLogicJoin(em);
    }

    public static void execBothDirection(EntityManager em){
        BothDirectionTeam team1 = new BothDirectionTeam("team1", "팀1");
        em.persist(team1);

        BothDirectionMember member1 = new BothDirectionMember("member1", "회원1");
        member1.setTeam(team1);
       //team1.getMembers().add(member1);
        em.persist(member1);

        BothDirectionMember member2 = new BothDirectionMember("member2", "회원2");
        member2.setTeam(team1);
        //team1.getMembers().add(member2);
        em.persist(member2);

        for(BothDirectionMember member : team1.getMembers()){
            System.out.println("Both Direction member.username=" + member.getUsername());
        }
    }

    public static void execOneDirectionMany(EntityManager em){
        OneDirectionProduct productA = new OneDirectionProduct();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        OneDirectionProduct productB = new OneDirectionProduct();
        productB.setId("productB");
        productB.setName("상품B");
        em.persist(productB);

        OneDirectionMember member1 = new OneDirectionMember();
        member1.setId("member1");
        member1.setUsername("회원");
        member1.getProducts().add(productA);
        member1.getProducts().add(productB);
        em.persist(member1);
    }
    public static void execBothDirectionMany(EntityManager em){
        BothDirectionProduct productA = new BothDirectionProduct();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        BothDirectionProduct productB = new BothDirectionProduct();
        productB.setId("productB");
        productB.setName("상품B");
        em.persist(productB);

        BothDirectionMember member1 = new BothDirectionMember();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.getProducts().add(productA);
        member1.getProducts().add(productB);
        em.persist(member1);

        BothDirectionMember member2 = new BothDirectionMember();
        member2.setId("member2");
        member2.setUsername("회원2");
        member2.getProducts().add(productA);
        member2.getProducts().add(productB);
        em.persist(member2);
    }

    public static void queryLogicJoin(EntityManager em){
        String jpql = "select m from OneDirectionMember m join m.team t where t.name=:teamName";
        List<OneDirectionMember> resultList = em.createQuery(jpql, OneDirectionMember.class)
                .setParameter("teamName", "팀1")
                .getResultList();
        for(OneDirectionMember member : resultList){
            System.out.println("One Direction member.username=" + member.getUsername());
        }

    }

    enum DirectionType{
        ONE_DIRECTION,
        BOTH_DIRECTION
    }

    enum MappingType{
        MANY_TO_ONE,
        ONE_TO_MANY,
        ONE_TO_ONE,
        MANY_TO_MANY
    }
}

