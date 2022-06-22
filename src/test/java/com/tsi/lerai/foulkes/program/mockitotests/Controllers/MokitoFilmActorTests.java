package com.tsi.lerai.foulkes.program.mockitotests.Controllers;

import com.tsi.lerai.foulkes.program.MyFirstMicroserviceApplication;
import com.tsi.lerai.foulkes.program.controller.ActorController;
import com.tsi.lerai.foulkes.program.controller.FilmActorController;
import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.filmactors.FilmActor;
import com.tsi.lerai.foulkes.program.repoandobj.filmactors.FilmActorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MokitoFilmActorTests {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;
    @MockBean
    private FilmActorRepo filmActorRepo;
    @InjectMocks
    FilmActorController filmActorController ;

    @BeforeEach
    void setup(){
        filmActorRepo = mock(FilmActorRepo.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication();
        filmActorController=new FilmActorController(filmActorRepo);
    }

    @Test
    public void fetchAllTests () {
        //Setup Mock Enviroment for actorRepo
        List<FilmActor> list = new ArrayList<FilmActor>();
        FilmActor dummyFilmActor = new FilmActor(1) ;
        list.add(dummyFilmActor);
        when(filmActorRepo.findAll()).thenReturn(list);
        List<FilmActor> expected = list;
        List<FilmActor> actual = filmActorController.fetchFilmActorId();
        //Tests
        verify(filmActorRepo).findAll();
        Assertions.assertEquals(list ,actual , "A list is not returned");
    }
}
