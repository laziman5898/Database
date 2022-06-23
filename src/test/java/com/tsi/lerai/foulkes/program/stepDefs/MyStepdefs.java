package com.tsi.lerai.foulkes.program.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MyStepdefs {

        private static final String BASE_URL = "http://localhost:8080/actors";

//        private static String token;
//        private static Response response;
//        private static String jsonString;
//        private static String bookId;


        @Given("I have the actor")
        public void i_have_the_actor() {
            // Write code here that turns the phrase above into concrete actions

        }

        @When("The actor input has a first name of {string} and last name {string}")
        public void the_actor_input_has_a_first_name_of_and_last_name(String string, String string2) {
            // Write code here that turns the phrase above into concrete actions

        }

        @Then("An actor with the first name {string} and the last name {string} will be added to the database")
        public void an_actor_with_the_first_name_and_the_last_name_will_be_added_to_the_database(String string, String string2) {



    }
}
