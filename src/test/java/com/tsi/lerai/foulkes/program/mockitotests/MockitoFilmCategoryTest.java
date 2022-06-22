package com.tsi.lerai.foulkes.program.mockitotests;

import com.tsi.lerai.foulkes.program.MyFirstMicroserviceApplication;
import com.tsi.lerai.foulkes.program.controller.ActorController;
import com.tsi.lerai.foulkes.program.controller.FilmCategoryController;
import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.filmcategorys.FilmCategory;
import com.tsi.lerai.foulkes.program.repoandobj.filmcategorys.FilmCategoryRepo;
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
public class MockitoFilmCategoryTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;
    @MockBean
    private FilmCategoryRepo filmCategoryRepo;
    @InjectMocks
    FilmCategoryController filmCategoryController ;
    @BeforeEach
    void setup(){
        filmCategoryRepo = mock(FilmCategoryRepo.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication();
        filmCategoryController=new FilmCategoryController(filmCategoryRepo);
    }

    @Test
    public void getFilmCategorysTest() {
        //Setup Mock Enviroment for actorRepo
        List<FilmCategory> list = new ArrayList<FilmCategory>();
        FilmCategory dummyFilmCategory = new FilmCategory() ;
        list.add(dummyFilmCategory);
        when(filmCategoryRepo.findAll()).thenReturn(list);
        List<FilmCategory> expected = list;
        List<FilmCategory> actual = filmCategoryController.getFilmCategorys();

        //Tests
        verify(filmCategoryRepo).findAll();
        Assertions.assertEquals(list ,actual , "A list is not returned");
    }
}
