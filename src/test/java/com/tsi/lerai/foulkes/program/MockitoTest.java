package com.tsi.lerai.foulkes.program;


import com.tsi.lerai.foulkes.program.controller.ActorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    @InjectMocks
    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;
    @Mock
    private ActorRepo actorRepo;
    @Mock
    private ActorController actorController ;

@BeforeEach
    void setup(){
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
    String actual = actorController.addActor(dummyActor.getFirst_name(),dummyActor.getLast_name());
    ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
    verify(actorRepo).save(actorArgumentCaptor.capture());
    Assertions.assertEquals("saved",actual,"entry is not saved into the database");
}
@Test
public void deleteActorEntry(){
    actorController.addActor("" ,"") ;
}

//@Test
//    public void actorContains(){
//    Actor dummyActor = new Actor("John" , "Doe") ;
//    String actual = actorController.addActor(dummyActor.getFirst_name(),dummyActor.getLast_name());
//    ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
//    verify(actorRepo).save(actorArgumentCaptor.capture());
//    Assertions.assertEquals(actorController.idExists(Long.valueOf(1)), true , "Does not work " );
//}
////@Test
//    public void updateActorEntry() {
//    String actual = actorController.updateActor(1L,"CHARLOTTE","HARRIS");
//    Assertions.assertEquals("Updated Successfully", actual , "The function did not complete");
//
//}
}
