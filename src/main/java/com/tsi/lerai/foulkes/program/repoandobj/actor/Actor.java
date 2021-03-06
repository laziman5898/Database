package com.tsi.lerai.foulkes.program.repoandobj.actor;

import javax.persistence.*;

@Entity
@Table(name="actor")
public class Actor {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long actor_id  ;
    //Attributes
    private String first_name ;
    private String last_name ;
    public Actor(String first_name, String last_name){
        this.first_name=first_name;
        this.last_name=last_name;
    }

    //Empty Constructor
    public Actor() {}

    //Getter and Setters

    public Long getActor_id() {
        return actor_id;
    }

    public void setActor_id(Long actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
