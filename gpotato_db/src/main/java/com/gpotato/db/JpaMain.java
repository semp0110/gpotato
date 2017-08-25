package com.gpotato.db;

import com.gpotato.entities.Member1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by hirang on 2017-08-14.
 */
public class JpaMain
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try
        {
            tx.begin();
            logic(em);
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
    private static void logic(EntityManager em){
        /*Member member = new Member();
        member.setId("id16");
        member.setUsername("3333333");
        member.setAge(3333);
*/
        //em.persist(member);

        for (int i=0; i<10; i++){
            Member1 member1 = new Member1();
            //member1.setId(i);
            member1.setUsername("9999999");
            member1.setAge(3333);
            member1.setMarried(true);
            member1.setCon(123123212);
            member1.setSti(1111);
            member1.setRoletype(Member1.RoleType.GUEST);
            em.persist(member1);

        }


        //등록
        //em.persist(member);

        //수정
//        member.setAge(33);
//        member.setUsername("랑스111111");

        //em.detach(member);


        //수정
//        em.merge(member);
        //em.remove(member);
        //한 건 조회
//        Member1 findMember = em.find(Member1.class, "id14");
//        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());

        //목록 조회
//        List<Member1> members = em.createQuery("select m from Member1 m", Member1.class).getResultList();
//        System.out.println("members.size=" + members.size());

        //삭제
        //em.remove(member);
    }
}
