Feature: Add a new Actor
As a user i would like to add a new actor

  Scenario: I successfully add an actor to a table

    Given I have the actor
    When The actor input has a first name of "John" and last name "Doe"
    Then An actor with the first name "John" and the last name "Doe" will be added to the database
