package com.tsi.lerai.foulkes.program.mockitotests.Controllers;

import com.tsi.lerai.foulkes.program.MyFirstMicroserviceApplication;
import com.tsi.lerai.foulkes.program.controller.ActorController;
import com.tsi.lerai.foulkes.program.controller.InventoryController;
import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.inventory.Inventory;
import com.tsi.lerai.foulkes.program.repoandobj.inventory.InventoryRepo;
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
public class MockitoInventoryTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;
    @MockBean
    private InventoryRepo inventoryRepo;
    @InjectMocks
    InventoryController inventoryController ;
    @BeforeEach
    void setup(){
        inventoryRepo = mock(InventoryRepo.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication();
        inventoryController=new InventoryController(inventoryRepo);
    }

    @Test
    public void fetchAllInventoryTests(){
        //Setup Mock Enviroment for actorRepo
        List<Inventory> list = new ArrayList<Inventory>();
        Inventory dummyInventory = new Inventory();
        list.add(dummyInventory);
        when(inventoryController.findAllInventory()).thenReturn(list);
        List<Inventory> expected = list;
        List<Inventory> actual = inventoryController.findAllInventory();

        //Tests
        verify(inventoryRepo).findAll();
        Assertions.assertEquals(list ,actual , "A list is not returned");

    }


}
