Feature: Add a new Actor
  As a user i would like to add a new actor

  Scenario: I successfully add an actor to a table

    Given I want to get all the actors
    When I request all actors using the url "/actors"
    And A user with the first name "PENELOPE" and the last name "GUINESS" exists
    And The response has more then 10 entries
    Then I will get the corresponding data returned
