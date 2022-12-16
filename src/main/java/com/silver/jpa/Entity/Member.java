package com.silver.jpa.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "USER")
public class Member {

    @Id
    private long id;
//    @Column(name = "user_name")
    private String name;

    public Member(){

    }
    public Member(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
