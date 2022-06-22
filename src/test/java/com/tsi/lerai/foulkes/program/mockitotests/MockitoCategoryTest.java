package com.tsi.lerai.foulkes.program.mockitotests;

import com.tsi.lerai.foulkes.program.MyFirstMicroserviceApplication;
import com.tsi.lerai.foulkes.program.controller.ActorController;
import com.tsi.lerai.foulkes.program.controller.CategoryController;
import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.category.Category;
import com.tsi.lerai.foulkes.program.repoandobj.category.CategoryRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoCategoryTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;
    @MockBean
    private CategoryRepo categoryRepo;
    @InjectMocks
    CategoryController categoryController ;

    @BeforeEach
    void setup(){
        categoryRepo = mock(CategoryRepo.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication();
        categoryController=new CategoryController(categoryRepo);
    }

    @Test
    public void categoryFetchAllTest () {
        //Setup Mock Enviroment for actorRepo
        List<Category> list = new ArrayList<Category>();
        Category dummyCategory = new Category("Shoot-em-up" ) ;
        dummyCategory.setActor_id(0L);
        list.add(dummyCategory);
        when(categoryRepo.findAll()).thenReturn(list);

        List<Category> expected = list;
        List<Category> actual = categoryController.categoryFetchAll();
        Assertions.assertEquals(expected,actual,"Values are not the same");

    }
}
