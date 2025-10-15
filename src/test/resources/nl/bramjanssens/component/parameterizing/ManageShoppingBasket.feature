Feature: Manage shopping basket

  Scenario: Add to basket
    Given I have a new empty basket
    When I add a "tv" to my basket
    Then The basket contains 1 item

  Scenario: Remove from basket
    Given I have a new empty basket
    When I add a "tv" to my basket
    And I remove the "tv" from my basket
    Then The basket is empty