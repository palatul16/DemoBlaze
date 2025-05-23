Feature: Sign Up Feature
  As a new user, I want to sign up on the application with valid and invalid details.

  Scenario: Sign up with valid details
    Given I am on the Sign Up page
    When I enter a new unique username
    And I enter a valid password
    And I click on the Sign Up button
    Then I should see a success message "Sign up successful."

  Scenario: Sign up with an existing username
    Given I am on the Sign Up page
    When I enter an already registered username
    And I enter a valid password
    And I click on the Sign Up button
    Then I should see an alert message "This user already exists."

  Scenario: Sign up with an empty username
    Given I am on the Sign Up page
    When I leave the username field empty
    And I enter a valid password
    And I click on the Sign Up button
    Then I should see an alert message "Please fill out the username field."

  Scenario: Sign up with an empty password
    Given I am on the Sign Up page
    When I enter a new unique username
    And I leave the password field empty
    And I click on the Sign Up button
    Then I should see an alert message "Please fill out the password field."

  Scenario: Sign up with both fields empty
    Given I am on the Sign Up page
    When I leave both username and password fields empty
    And I click on the Sign Up button
    Then I should see an alert message "Please fill out all required fields."
