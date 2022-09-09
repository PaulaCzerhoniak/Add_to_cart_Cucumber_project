Feature: Amazon cart
  Scenario: Add an item to the Amazon cart
    Given user opens Amazon
    And chooses category
    When user adds product to the cart
    Then user verifies that is in the cart
