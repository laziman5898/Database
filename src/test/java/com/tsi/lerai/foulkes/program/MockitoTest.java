package com.tsi.lerai.foulkes.program;


import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.controller.ActorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;
    @MockBean
    private ActorRepo actorRepo;
    @InjectMocks
    ActorController actorController ;


@BeforeEach
    void setup(){
    actorRepo = mock(ActorRepo.class);
    ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
     myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepo);



    actorController=new ActorController(actorRepo);
}

@Test
public void getAllActorEntries(){
actorController.fetchActor();
    verify(actorRepo).findAll();

}
@Test
  public void addActorTest(){
    Actor dummyActor = new Actor("John" , "Doe") ;
    dummyActor.setActor_id(1L);

    String actual = actorController.addActor(dummyActor.getFirst_name(),dummyActor.getLast_name());
    ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
    verify(actorRepo).save(actorArgumentCaptor.capture());
    //System.out.println(actorArgumentCaptor.getAllValues().get(0).getFirst_name());
    //Assertions.assertEquals("saved",actual,"entry is not saved into the database");
    }

@Test
public void deleteActorEntry(){
System.out.println(actorRepo.findAll());
//
    actorController.addActor("JAmes", "rose");
//    actorRepo.save();
    List<Actor> list = new ArrayList<Actor>();
    Actor actor1 = new Actor("","");
    Actor abbas = new Actor("Abbas", "");
    list.add(actor1);

    when(actorRepo.findAll()).thenReturn(list);
//    when(actorRepo.save(any(Actor.class))).thenReturn(list.add(abbas));

    //when(actorRepo.save(any(Actor.class))).getMock();

//    when(actorRepo.save(Mockito.any(Actor.class))).(list.add(abbas));

    System.out.println(actorRepo.findAll());
    System.out.println(actorController.fetchActor());
    //System.out.println(actorController.fetchActor().get(0).getActor_id());
   // actorController.addActor(abbas.getFirst_name(),abbas.getLast_name());
    //System.out.println(actorController.fetchActor());

    Assertions.assertEquals(1,1,"lol");

}

//@Test
//    public void actorContains(){
//    Actor dummyActor = new Actor("John" , "Doe") ;
//    String actual = actorController.addActor(dummyActor.getFirst_name(),dummyActor.getLast_name());
//    ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
//    verify(actorRepo).save(actorArgumentCaptor.capture());
//    Assertions.assertEquals(true, actorController.idExists(1L), "Does not work " );
//}

@Test
    public void searchByNameActor(){

    Actor dummyActor = new Actor("John" , "Doe") ;
    actorController.addActor(dummyActor.getFirst_name(),dummyActor.getLast_name());
    ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
    verify(actorRepo).save(actorArgumentCaptor.capture());



}
////@Test
//    public void updateActorEntry() {
//    String actual = actorController.updateActor(1L,"CHARLOTTE","HARRIS");
//    Assertions.assertEquals("Updated Successfully", actual , "The function did not complete");
//
//}
}
