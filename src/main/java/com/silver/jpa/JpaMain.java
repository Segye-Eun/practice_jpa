package com.silver.jpa;

import com.silver.jpa.Entity.Member;
import com.silver.jpa.Entity.RoleType;
import com.silver.jpa.Entity.Team;

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


//            //JPQL
//            // 대상이 테이블이 아닌 객체가 된다
//            List<Member> findMembers = em.createQuery("select m from Member as m", Member.class)
//                    // 페이징 시작(limit)
//                    .setFirstResult(0)
//                    // 페이징 끝(offset)
//                    .setMaxResults(8)
//                    .getResultList();
//            for(Member member : findMembers){
//                System.out.println("member.name = " + member.getName());
//            }

//            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloSilver");
//
//            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            System.out.println("result = " + (findMember1 == findMember2));
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");

//            em.persist(member1);
//            em.persist(member2);

//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");
//            // 업데이트는 set 후에 persist를 다시 적을 필요가 없다

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            // 커핏 전에 쿼리 발동(플러시를 하더라도 1차캐쉬가 다 지워지진않는다, 쓰기지연 SQL 저장소에 있는게 db에 반영이 되는것일뿐)
//            em.flush();

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");

//            // 준영속 -> 특정 엔티티만 영속성 컨텍스트에서 빠지게 됨 -> 업데이터 안됨
//            em.detach(member);

//            // 영속성 컨텍스트 내에 있는것을 통으로 날려버림
//            em.clear();
//            // 1차 캐시가 다 날아가서 다시 db에서 조회한다
//            Member member2 = em.find(Member.class, 150L);
//            System.out.println("=======================");

//            Member member = new Member();
//            member.setUsername("C");
//            member.setRoleType(RoleType.ADMIN);
//            em.persist(member);

//            Member member1 = new Member();
//            member1.setUsername("A");
//
//            Member member2 = new Member();
//            member2.setUsername("B");
//
//            Member member3 = new Member();
//            member3.setUsername("C");
//
//            System.out.println("=====================");
//
//            //DB SEQ = 1     |   1
//            //DB SEQ = 51     |   2
//            //DB SEQ = 51     |   3
//
//            em.persist(member1); //1, 51
//            em.persist(member2); // 메모리에서 호출
//            em.persist(member3); // 메모리에서 호출
//
//            System.out.println("member1 = " + member1.getId());
//            System.out.println("member2 = " + member2.getId());
//            System.out.println("member3 = " + member3.getId());
//
//            System.out.println("=====================");

            //단방향 연관관계
            // 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());

            Team findTeam =  findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            // 업데이트
            Team newTeam = em.find(Team.class, 100L);
            findMember.setTeam(newTeam);
            //단방향 끝



            // 커밋하는 순간에 쿼리로 넘어간다
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
