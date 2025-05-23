Feature: Checkout Process

  Scenario: Validate Checkout Process with valid details
    Given I add "Samsung galaxy s6" to the cart
    When I proceed to checout
    And I enter valid detakils "John Doe", "USA", "New York", "1234567812345678", "12", "2025"
    And I confirm the purchase
    Then the order should be completed successfully

  Scenario: Validate Checkout Without Entering Details
    Given I add "Samsung galaxy s6" to the cart
    When I proceed to checkout
    And I confirm the purchase
    Then I should see an error message 

  Scenario: Validate Checkout With Invalid Card
    Given I add "Sony vaio i5" to the cart
    When I proceed to checkout
    And I enter invalid card details "Alice Smith", "UK", "London", "INVALIDCARD123", "05", "2026"
    And I confirm the purchase
    Then I should see an error message

  Scenario: Validate Checkout With Expired Card
    Given I add "MacBook Air" to the cart
    When I proceed to checkout
    And I enter expired card details "Michael Brown", "Canada", "Toronto", "5555666677778888", "08", "2020"
    And I confirm the purchase
    Then I should see an error message

  Scenario: Validate Checkout With Multiple Products
    Given I add multiple products "Samsung galaxy s6" and "Sony vaio i5" to the cart
    When I proceed to checkout
    And I enter valid details "Emma Johnson", "Germany", "Berlin", "9876543210987654", "11", "2027"
    And I confirm the purchase
    Then the order should be completed successfully
