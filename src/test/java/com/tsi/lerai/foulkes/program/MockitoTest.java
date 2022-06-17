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
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
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
    //Setup Mock Enviroment for actorRepo
    List<Actor> list = new ArrayList<Actor>();
    Actor actor = new Actor("John","Doe");
    actor.setActor_id(0L);
    list.add(actor);
    when(actorRepo.findAll()).thenReturn(list);
    List<Actor> expected = list;
    List<Actor> actual = actorController.fetchActor();

    //Tests
    verify(actorRepo).findAll();
    Assertions.assertEquals(list ,actual , "A list is not returned");
    Assertions.assertEquals(0L , actorController.fetchActor().get(0).getActor_id(), "Actor id is  not 0");
    Assertions.assertEquals("John" , actorController.fetchActor().get(0).getFirst_name(), "Actor name is  not John");
    Assertions.assertEquals("Doe" , actorController.fetchActor().get(0).getLast_name(), "Actor Last name is not Doe");
    Assertions.assertEquals(1,actorController.fetchActor().size(),"All actors were not fetched");


}
@Test
  public void addActorTest(){
    //Setup Mock for add Actor Test - Return an actor
    Actor actor = new Actor("John","Doe");
    when(actorRepo.save(any(Actor.class))).thenReturn(actor);
    String actual = actorController.addActor(actor.getFirst_name(),actor.getLast_name());
    String expected = "saved";

    //Tests
    Assertions.assertEquals(expected,actual,"The Function was unable to complete");

    }

@Test
public void deleteActorEntry(){

    //Setup
    Long i = 10L ;
    Actor actor = new Actor("John","Doe");
    actor.setActor_id(0L);

//    doNothing().when(actorRepo.deleteById(anyLong())).th(null);

    String actual = actorController.deleteActorById(actor.getActor_id());
    String expected = "Deleted Successfully";

    //Tests
    Assertions.assertEquals(expected,actual,"The function was unable to complete");

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
    //Setup Mock Enviroment for actorRepo
    List<Actor> list = new ArrayList<Actor>();
    Actor actor1 = new Actor("John","Doe");
    Actor actor2 = new Actor("Sarah","Smith");
    actor1.setActor_id(0L);
    actor2.setActor_id(1L);
    list.add(actor1);
    list.add(actor2);
    when(actorRepo.findAll()).thenReturn(list);
    List<Actor> expected = list;
    List<Actor> actual = actorController.fetchActor();
    // Actual & Expected
    Long actualId1 = actorController.getActorInfo("John").getActor_id();
    String actualFirstName1 = actorController.getActorInfo("John").getFirst_name();
    String actualLastName = actorController.getActorInfo("John").getLast_name();
    Long actualId2 = actorController.getActorInfo("Sarah").getActor_id();
    String actualFirstName2 = actorController.getActorInfo("Sarah").getFirst_name();
    String actualLastName2 = actorController.getActorInfo("Sarah").getLast_name();

    Long expectedId1 = 0l;
    Long expectedId2 = 1l;
    String expectedFirstname1 = "John" ;
    String expectedFirstname2 = "Sarah" ;
    String expectedLastname1 = "Doe" ;
    String expectedLastname2 = "Smith";

    //Tests
    Assertions.assertEquals(expectedId1,actualId1,"Johns Actual Id is not as expected");
    Assertions.assertEquals(expectedId2,actualId2,"Sarah's Actual Id is not as expected");
    Assertions.assertEquals(expectedFirstname1,actualFirstName1,"Johns Actual First Name is not as expected");
    Assertions.assertEquals(expectedFirstname2,actualFirstName2,"Sarah's Actual Id is not as expected");
    Assertions.assertEquals(expectedLastname1,actualLastName,"Johns Actual Last name is not as expected");
    Assertions.assertEquals(expectedLastname2,actualLastName2,"Sarah's Actual Last Name is not as expected");


    //Test
    Assertions.assertEquals(1,1,"");


}
////@Test
//    public void updateActorEntry() {
//    String actual = actorController.updateActor(1L,"CHARLOTTE","HARRIS");
//    Assertions.assertEquals("Updated Successfully", actual , "The function did not complete");
//
//}
}
