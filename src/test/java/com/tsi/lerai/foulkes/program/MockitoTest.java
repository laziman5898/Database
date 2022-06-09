package com.tsi.lerai.foulkes.program;


import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import com.tsi.lerai.foulkes.program.repoandobj.actor.ActorRepo;
import com.tsi.lerai.foulkes.program.controller.ActorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;
    @Mock
    private ActorRepo actorRepo;
    @Mock
    private ActorController actorController ;

@BeforeEach
    void setup(){
    actorRepo = mock(ActorRepo.class);
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
    Assertions.assertEquals("saved",actual,"entry is not saved into the database");
    }

@Test
public void deleteActorEntry(){
    Actor dummyActor = new Actor("John" , "Doe") ;

    actorController.addActor(dummyActor.getFirst_name(),dummyActor.getLast_name());
    ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
    verify(actorRepo).save(actorArgumentCaptor.capture());

//    actorArgumentCaptor.getAllValues().get(0).setActor_id(0l);
    System.out.println(actorArgumentCaptor.getAllValues().get(0).getActor_id());

//actorController.deleteActorById(0l);

    System.out.println(actorArgumentCaptor.getAllValues().size());

    //Assertions.assertEquals(0 ,actorArgumentCaptor.getAllValues().size(),"entry is not deleted out the database");
    //Assertions.assertEquals(true ,actorRepo.existsById(1L),"entry is not deleted out the database");
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
