package com.tsi.lerai.foulkes.program.mockitotests.Controllers;

import com.tsi.lerai.foulkes.program.MyFirstMicroserviceApplication;
import com.tsi.lerai.foulkes.program.controller.ActorController;
import com.tsi.lerai.foulkes.program.controller.MovieController;
import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.movies.Movie;
import com.tsi.lerai.foulkes.program.repoandobj.movies.MovieRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoFilmTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;

    @MockBean
    private MovieRepo movieRepo;
    @InjectMocks
    MovieController movieController ;

    @BeforeEach
    void setup(){
        movieRepo = mock(MovieRepo.class);
        //ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication();
        movieController = new MovieController(movieRepo) ;
    }

    @Test
    public void fetchAllMoviesTest(){
       //Setup Mock Enviroment for MovieRepo
        List<Movie> movieList = new ArrayList<Movie>();
        Movie movie1 = new Movie("John Wick" ,123 , "PG");
        Movie movie2 = new Movie("Batman" ,210 , "18");
        movie1.setFilm_id(0L);
        movie2.setFilm_id(1L);
        movieList.add(movie1);
        movieList.add(movie2);
        //Behaviour
        when(movieRepo.findAll()).thenReturn(movieList);
        //Test 1
        List<Movie> expected = movieList;
        List<Movie> actual = movieController.fetchMovies() ;
        Assertions.assertEquals(expected , actual , "The List is different ");
        //Test2
        String expectedTitle = movie1.getTitle() ;
        String actualTitle = movieController.fetchMovies().get(0).getTitle() ;
        Assertions.assertEquals(expectedTitle , actualTitle , "The List is different ");
    }

    @Test
    public void getFilmsByIdTest () {
        //Setup Mock Enviroment for MovieRepo
        List<Movie> movieList = new ArrayList<Movie>();
        Movie movie1 = new Movie("John Wick" ,123 , "PG");
        Movie movie2 = new Movie("Batman" ,210 , "18");
        movie1.setFilm_id(0L);
        movie2.setFilm_id(1L);
        movieList.add(movie1);
        movieList.add(movie2);
        Long selectedIdLong = 1L ;
        //Setup Behaviour
        when(movieRepo.findById(selectedIdLong)).thenReturn(Optional.of(movie2));
        String expected = movie2.getTitle();
        String actual = movieController.getFilmIdToString(selectedIdLong) ;
        Assertions.assertEquals(expected,actual, "The title is not the same");

    }
    @Test
    public void getFilmTitleTest() {
        //Setup Mock Envniroment for MovieRepo
        List<Movie> movieList = new ArrayList<Movie>();
        Movie movie1 = new Movie("John Wick" ,123 , "PG");
        Movie movie2 = new Movie("Batman" ,210 , "18");
        movie1.setFilm_id(0L);
        movie2.setFilm_id(1L);
        movieList.add(movie1);
        movieList.add(movie2);

        String chosenTitle = "Batman" ;

        when(movieRepo.findAll()).thenReturn(movieList);

        Movie expected = movie2 ;
        Movie actual = movieController.getFilmInfo(chosenTitle) ;

        Assertions.assertEquals(expected,actual,"The movies are different");
    }
}
