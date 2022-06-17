package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.filmcategorys.FilmCategory;
import com.tsi.lerai.foulkes.program.repoandobj.filmcategorys.FilmCategoryRepo;
import com.tsi.lerai.foulkes.program.repoandobj.movies.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmCategoryController {



    @Autowired private FilmCategoryRepo filmCategoryRepo;

    public FilmCategoryController (FilmCategoryRepo filmCategoryRepo){this.filmCategoryRepo= filmCategoryRepo;}

    @GetMapping("/filmcategorys")
    public List<FilmCategory> getFilmCategorys() {
        return (List<FilmCategory>) filmCategoryRepo.findAll();
    }

}
