package com.tsi.lerai.foulkes.program.mockitotests.Controllers;

import com.tsi.lerai.foulkes.program.MyFirstMicroserviceApplication;
import com.tsi.lerai.foulkes.program.controller.ActorController;
import com.tsi.lerai.foulkes.program.controller.StaffController;
import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.repoandobj.staff.Staff;
import com.tsi.lerai.foulkes.program.repoandobj.staff.StaffRepo;
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
public class MockitoStaffTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;
    @MockBean
    private StaffRepo staffRepo;
    @InjectMocks
    StaffController staffController ;
    @BeforeEach
    void setup(){
        staffRepo = mock(StaffRepo.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication();
        staffController=new StaffController(staffRepo);
    }

    @Test
    public void fetchAllStaff(){
        //Setup Mock Enviroment for actorRepo
        List<Staff> list = new ArrayList<Staff>();
        Staff dummystaff = new Staff() ;
        list.add(dummystaff);
        when(staffRepo.findAll()).thenReturn(list);
        List<Staff> expected = list;
        List<Staff> actual = staffController.getAllStaff();
        //Tests
        verify(staffRepo).findAll();
        Assertions.assertEquals(list ,actual , "A list is not returned");
    }
}
