package com.tsi.lerai.foulkes.program.repoandobj.filmactors;

import javax.persistence.*;

@Entity
@Table(name="film_actor")
public class FilmActor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long actor_id ;

    //Attributes
    private int film_id ;

    public FilmActor(int film_id){
        this.film_id= film_id;
    }

    public FilmActor(){}

    public Long getActor_id() {
        return actor_id;
    }

    public void setActor_id(Long actor_id) {
        this.actor_id = actor_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
