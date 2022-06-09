package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.movies.Movie;
import com.tsi.lerai.foulkes.program.repoandobj.movies.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired private MovieRepo movieRepo ;

    public MovieController (MovieRepo movieRepo) {this.movieRepo = movieRepo ; }

    //Return
    @GetMapping("/films")
    public List<Movie> fetchActor() {
        return (List<Movie>) movieRepo.findAll();
    }



}
