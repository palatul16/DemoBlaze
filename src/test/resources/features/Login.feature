# Author:  
# Date:  
# Description: Testing login functionality with valid and invalid credentials.

Feature: User Login
  As a user, I want to log in with valid credentials and receive appropriate feedback for invalid attempts.

  Background: 
    Given I am on the login page

  Scenario: Login with valid credentials
    When I enter a valid email and password
    And I click the login button
    Then I should see the "Log out" button

  Scenario: Login with invalid password
    When I enter a valid email and an invalid password
    And I click the login button
    Then I should see an alert message "Wrong password."

  Scenario: Login with an invalid email
    When I enter an invalid email and a valid password
    And I click the login button
    Then I should see an alert message "User does not exist."

  Scenario: Login without credentials
    When I leave the email and password fields empty
    And I click the login button
    Then I should see an alert message "Please fill out Email and Password fields."

