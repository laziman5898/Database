package com.tsi.lerai.foulkes.program.repoandobj.filmcategorys;

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@Entity
@Table(name = "film_category")
public class FilmCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long film_id  ;

    //Attributes
    private int category_id;


    public FilmCategory (){}

    public Long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
