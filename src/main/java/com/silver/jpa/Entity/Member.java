package com.silver.jpa.Entity;

import javax.persistence.*;

@Entity
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 50)
public class Member {

//    @Id
//    private long id;
//
//    @Column(name = "name", nullable = false)
//    private String username;
//
//    private int age;
//
//    // ORDINAL : enum 순서를 db에 저장(위험함, 순서바뀌면 큰일난다)
//    // STRING : enum 이름을 db에 저장
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    // 최신버전은 이걸로 과거버전은 temporal 사용
//    private LocalDate testLocalDate;
//    private LocalDateTime testLocalDateTime;
//
//    // 매핑하는 필드 타입이 문자면 CLOB 매핑, 나머지는 BLOB
//    @Lob
//    private String description;
//
//    @Transient
//    private int temp;


    // 직접할당할 경우 @ID
    // 자동생성일 경우 @GeneratedValue
    // mysql - a.i oracle - sequence
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,
//            generator = "MEMBER_SEQ_GENERATOR")
//    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE,
//            generator = "MEMBER_SEQ_GENERATOR")
//    private Long id;

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        // 연관관계 편의 메소드
        team.getMembers().add(this);
    }

}
