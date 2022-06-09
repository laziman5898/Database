package com.tsi.lerai.foulkes.program;

import com.tsi.lerai.foulkes.program.controller.ActorController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ActorStepDef {

    Actor testingActor;

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication ;

    private ActorRepo actorRepo;

    private ActorController actorController ;

    @Given("I have the actor")
    public void i_have_the_actor() {
        // Write code here that turns the phrase above into concrete actions
    actorRepo = mock(ActorRepo.class);
    }
    @When("The actor input has a first name of {string} and last name {string}")
    public void the_actor_input_has_a_first_name_of_and_last_name(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions

        testingActor = new Actor(string,string2) ;
    }
    @Then("An actor with the first name {string} and the last name {string} will be added to the database")
    public void an_actor_with_the_first_name_and_the_last_name_will_be_added_to_the_database(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions


        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepo);
        actorController = new ActorController(actorRepo);

        String actual = actorController.addActor(testingActor.getFirst_name(),testingActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepo).save(actorArgumentCaptor.capture());

        String expectedfirstname = testingActor.getFirst_name();
        String expectedLastName = testingActor.getLast_name();

        String actualfirstname = actorArgumentCaptor.getAllValues().get(0).getFirst_name();
        String actualLastName = actorArgumentCaptor.getAllValues().get(0).getLast_name();

        System.out.println(actorArgumentCaptor.getAllValues().get(0).getActor_id());

        Assertions.assertEquals(expectedfirstname,actualfirstname,"entry is not saved into the database");
        Assertions.assertEquals(expectedLastName,actualLastName,"entry is not saved into the database");


    }


    }

