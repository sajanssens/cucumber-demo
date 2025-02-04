Feature: Add to DI shopping basket

  Scenario: Add products to DI basket
    Given I have an empty di basket
    When I add these products:
      | banana |
      | carrot |
      | tv     |
    Then It should contain 3 products