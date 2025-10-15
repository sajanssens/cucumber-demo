Feature: Add to shopping basket
  Note for developers: this basket works with mockito mocks.

  Scenario: Add products to mocked basket
    Given I have an empty mocked basket
    When I add these products:
      | banana |
      | carrot |
      | tv     |
    And the products are in stock
    Then It should contain 3 products