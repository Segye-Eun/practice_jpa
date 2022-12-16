package com.silver.jpa;

import com.silver.jpa.Entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // 서버 로딩 시점에 딱 한번만 만들기
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 매니저가 계속 만들어져야함(쓰레드간에 공유 X)
        EntityManager em = emf.createEntityManager();
        // JPA 모든 데이터 변경은 트랜잭션 내에서 실행시켜야 한다
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            //등록
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloWorld");
//            em.persist(member);
//            // 조회
//            Member findMember = em.find(Member.class, 2L);
//            // 삭제
//            em.remove(findMember);
//            // 수정
//            findMember.setName("HelloSilver");

            //JPQL
            // 대상이 테이블이 아닌 객체가 된다
            List<Member> findMembers = em.createQuery("select m from Member as m", Member.class)
                    // 페이징 시작(limit)
                    .setFirstResult(0)
                    // 페이징 끝(offset)
                    .setMaxResults(8)
                    .getResultList();
            for(Member member : findMembers){
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
