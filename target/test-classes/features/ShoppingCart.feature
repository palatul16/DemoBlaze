Feature: Shopping Cart Functionality

  Scenario: Validate adding product to cart without login
    Given I am on the home page
    When I select the product "Samsung galaxy s6"
    And I add the product to the cart
    Then I should see an alert with message "Product added"
    And I should see "Samsung galaxy s6" in the cart

  Scenario: Add multiple products to cart
    Given I am on the home page
    When I select the product "Samsung galaxy s6"
    And I add the product to the cart
    And I navigate back to home
    And I select the product "Sony vaio i5"
    And I add the product to the cart
    Then I should see "Samsung galaxy s6" in the cart
    And I should see "Sony vaio i5" in the cart

  Scenario: Remove product from cart
    Given I am on the home page
    When I select the product "Samsung galaxy s6"
    And I add the product to the cart
    And I open the cart
    And I remove the product
    Then I should not see "Samsung galaxy s6" in the cart
