package com.tsi.lerai.foulkes.program.stepDefs;

import com.tsi.lerai.foulkes.program.repoandobj.actor.Actor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Scope(SCOPE_CUCUMBER_GLUE)
public class JsonReturnStepDefs {
    @LocalServerPort
    int port ;
    private final RestTemplate restTemplate = new RestTemplate();

    private ResponseEntity<Actor[]> actors;
    @Given("I want to get all the actors")
    public void getAllActors(){

    }
    @When("I request all actors using the url {string}")
    public void requestAllActors(String string1) {

        actors =  restTemplate.getForEntity("http://localhost:"+port + string1 , Actor[].class);
        System.out.println(actors);
    }

    @When("A user with the first name {string} and the last name {string} exists")
    public void checkNamesExist(String string1 , String string2){
        boolean contains = false;

        for (int i=0 ; i<actors.getBody().length;i++){
            if (actors.getBody()[i].getFirst_name().equals(string1)&& actors.getBody()[i].getLast_name().equals(string2)){

                contains = true ;
            }
        }

        Assertions.assertEquals(true , contains ,"This does not match ");
    }

    @When("The response has more then {int} entries")
    public void checkLimit(int int1) {
        boolean actual = false ;
        if(actors.getBody().length>10){ actual=true ; }
        Assertions.assertEquals(true , actual );
    }
    @Then("I will get the corresponding data returned")
    public void dataReturned(){

    }
}
