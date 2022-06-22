package com.tsi.lerai.foulkes.program.mockitotests;

import com.tsi.lerai.foulkes.program.MyFirstMicroserviceApplication;
import com.tsi.lerai.foulkes.program.controller.ActorController;
import com.tsi.lerai.foulkes.program.controller.StoreController;
import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.store.Store;
import com.tsi.lerai.foulkes.program.repoandobj.store.StoreRepo;
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
public class MockitoStoreTests {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;
    @MockBean
    private StoreRepo storeRepo;
    @InjectMocks
    StoreController storeController ;
    @BeforeEach
    void setup(){
        storeRepo = mock(StoreRepo.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication();
        storeController=new StoreController(storeRepo);
    }

    @Test
    public void getAllStores (){
        //Setup Mock Enviroment for actorRepo
        List<Store> list = new ArrayList<Store>();
       Store dummyStore = new Store() ;
        list.add(dummyStore);
        when(storeRepo.findAll()).thenReturn(list);
        List<Store> expected = list;
        List<Store> actual = storeController.getAllStores();
        //Tests
        verify(storeRepo).findAll();
        Assertions.assertEquals(list ,actual , "A list is not returned");
    }
}
