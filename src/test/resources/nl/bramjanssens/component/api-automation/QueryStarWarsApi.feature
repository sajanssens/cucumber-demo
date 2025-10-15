Feature: Query the people from star wars

  Scenario Outline: Finding people
    Given I go to SWAPI
    When I search for person <id>
    Then I get a successful response
    And the person name is "<name>"
    Examples:
      | id | name  |
      | 1  | Luke  |
      | 2  | C-3PO |
