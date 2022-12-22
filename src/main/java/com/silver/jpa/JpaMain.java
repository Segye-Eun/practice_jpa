package com.silver.jpa;

import com.silver.jpa.Entity.Item;
import com.silver.jpa.Entity.Member;
import com.silver.jpa.Entity.Movie;
import com.silver.jpa.Entity.Team;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
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

//            //단방향 연관관계
//            // 저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.changeTeam(team); // **
//            em.persist(member);


//            team.getMembers().add(member); // ** 양쪽에 값을 다 설정해야한다 -> flush, clear를 사용할 경우는 필요없음

//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId()); // 1차 캐시
//            List<Member> members = findMember.getTeam().getMembers();
//
//            System.out.println("===========================");
//            for(Member m : members){
//                System.out.println("m = " + m.getUsername());
//            }
//            System.out.println("===========================");

//            //일대다
//            Member member = saveMember(em);
//
//            Team team = new Team();
//            team.setName("teamA");
//            //
//            team.getMembers().add(member);
//
//            em.persist(team);


//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과함께사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
////            Movie findMovie = em.find(Movie.class, movie.getId());
//            Item item = em.find(Item.class, movie.getId());
//            System.out.println("item = " + item);

//            Member member = em.find(Member.class, 1L);
//            printMember(member);
//            printMemberAndTeam(member);

//            em.persist(member);

//            Member member1 = new Member();
//            member1.setUsername("hello1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("hello2");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();

//            Member m1 = em.find(Member.class, member1.getId());
////            Member m2 = em.find(Member.class, member2.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//            // find로 찾은 엔티티는 서로 == 비교시 true 반환
//            // 프록시랑 비교하면 false 반환
//            System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass()));
//            // 타입이 같은지로 비교를 해야한다
//            System.out.println("m1 == m2 : " + (m1 instanceof Member));
//            System.out.println("m1 == m2 : " + (m2 instanceof Member));
//
//            // 이것은 영속상태 실제 엔티티
//            System.out.println("m1 = " + m1.getClass());
//
//            Member reference = em.getReference(Member.class, member1.getId());
//            // 이미 영속성 컨텍스트에 실제 엔티티가 있어서 프록시 객체 대신 엔티티 반환
//            System.out.println("reference.getClass() = " + reference.getClass());
//            // 같은 영속성 컨텍스트에서 조회한 것이라 true 반환
//            System.out.println("m1 = reference : " + (m1 == reference));
            

//            // 프록시는 껍데기만 있는 가짜이다 -> 겉모양이 같다
//            // 엔티티를 상속 받아서 만들어짐
//            // 프록시 객체는 실제 객체의 참조(타겟)을 보관
//            // 첫 초기화 요청 이후에는 초기화 되지않는다(이미 조회가 끝나서 실제 엔티티 생성)
//
//            Member findMember = em.getReference(Member.class, member.getId());
//            //class com.silver.jpa.Entity.Member$HibernateProxy$ln4LR21b 이런식으로 프록시 클래스로 나온다(가짜)
//            System.out.println("findMember.getClass() = " + findMember.getClass());
//            // 레퍼런스로 찾을때 이미 id로 조회했기 때문에 쿼리 호출 없이 그냥 가져올수 있음.
//            System.out.println("findMember.getId() = " + findMember.getId());
//            // 이름은 프록시 객체 내부에 없어서 db에서 가져와야 하기 때문에 쿼리를 호출한다.
//            System.out.println("findMember.getUsername() = " + findMember.getUsername());
//            // 초기화 되었다고 해서 값만 채워지는것이지 실제 엔티티로 바뀌는게 아니다
//            // 프록시 객체를 통해서 실제 엔티티에 접근이 가능한것뿐
//            // ==으로 비교 불가, instance of 를 사용해서 비교해야한다
//            System.out.println("findMember.getClass() = " + findMember.getClass());
            
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass()); // proxy
//
//            // 프록시를 호출하고 초기화를 안 시킬경우 find 해도 프록시가 호출됨
//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println("findMember = " + findMember.getClass()); // Member -> 실제 엔티티가 아니라 프록시로 반환
//
//            // 그래서 true 가 나옴
//            System.out.println("refMember == findMember = " + (refMember == findMember));

//            // 자주 볼 수 있는 이슈 사항
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass()); // proxy
//
//            // 영속성 컨텍스트에서 제외, 영속성 컨텍스트를 클리어, 엔티티매니저를 닫아버리면
//            em.detach(refMember);
////            em.close();
////            em.clear();
//
//            // 영속성 컨텍스트의 도움을 받지 못하기 때문에
//            // could not initialize proxy 라고 뜨면서 익셉션 발생
//            // 프록시를 초기화 시킬 수 없다
//            refMember.getUsername();


            Member member1 = new Member();
            member1.setUsername("hello1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass()); // proxy
            // 프록시 인스턴스의 초기화 여부 확인 -> true or false 반환
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
//            refMember.getUsername(); // 강제 호출해서 초기화
            Hibernate.initialize(refMember); // 강제 초기화
            // 초기화 후에는 true 반환
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));





            // 커밋하는 순간에 쿼리로 넘어간다
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("member = " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }

    private static Member saveMember(EntityManager em) {
        Member member = new Member();
        member.setUsername("member1");

        em.persist(member);
        return member;
    }
}
