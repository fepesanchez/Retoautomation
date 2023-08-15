Feature: InitPage

  Background:
    Given i am in the home page
    When i type user and password
    And i click on the login button
    Then i can see init page

  Scenario: add trainer
    Given i click on the button list of trainers
    And i click on the button Add trainer
    When i complete the data
    And i click on the button create trainer
    Then i can see the client created
