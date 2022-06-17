package com.tsi.lerai.foulkes.program.controller;

import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.movies.Movie;
import com.tsi.lerai.foulkes.program.repoandobj.movies.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired private MovieRepo movieRepo ;

    public MovieController (MovieRepo movieRepo) {this.movieRepo = movieRepo ; }

    //Return
    @GetMapping("/films")
    public List<Movie> fetchMovies() {
        return (List<Movie>) movieRepo.findAll();
    }

    @GetMapping("/filmsbyid")
    public String getFilmIdToString (@RequestParam Long film_id){
        Movie currentMovie;
        currentMovie = movieRepo.findById(film_id).get();
       return currentMovie.getTitle() ;
    }
    @GetMapping("/films/SearchByName")
    public @ResponseBody Movie getFilmInfo(@RequestParam String title){
        List<Movie> movies = fetchMovies();
        Movie foundMovie = new Movie();
        for(int i =0 ; i <movies.size(); i++){
            Movie currentMovie = movies.get(i);
            if(currentMovie.getTitle().contains(title) ){
                foundMovie = currentMovie ;
            }
        }
        return foundMovie ;
    }

}
