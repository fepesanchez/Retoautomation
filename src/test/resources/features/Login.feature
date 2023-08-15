Feature: Login

  Scenario: login successful
    Given i am in the home page
    When i type user and password
    And i click on the login button
    Then i can see init page