package com.silver.jpa.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    // 영속성전이나 고아 객체 삭제 사용할 때는
    // 게시판이나 첨부파일같이 하나의 데이터가 여러 자식을 관리할땐 쓸수있음
    // 하지만 여러군데에서 사용하는 경우엔 사용하면 안됨
    // 라이프사이클이 유사할때, 단일 소유자일때 사용
    // 두가지 옵션을 다 사용하게 되면 부모엔티티가 자식 생명주기를 관리하게된다
    // 만들때 같이 만들어지고 지울때 같이 지움
    private List<Child> childList = new ArrayList<>();

    public void addChild(Child child){
        childList.add(child);
        child.setParent(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildList() {
        return childList;
    }
}
