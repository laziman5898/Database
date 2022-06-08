package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.Actor;
import com.tsi.lerai.foulkes.program.ActorRepo;
import com.tsi.lerai.foulkes.program.movies.Movie;
import com.tsi.lerai.foulkes.program.movies.MovieRepo;
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
