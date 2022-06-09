package com.tsi.lerai.foulkes.program.repoandobj.category;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long actor_id  ;

    //Attribute
    private String name ;

    public Category(String name ){
      this.name = name;

    }

    public Category() {}

    public Long getActor_id() {
        return actor_id;
    }

    public void setActor_id(Long actor_id) {
        this.actor_id = actor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
