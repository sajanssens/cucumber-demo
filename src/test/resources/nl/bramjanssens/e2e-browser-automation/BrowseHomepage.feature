Feature: Browse homepage

  @browser
  Scenario: Check the header on the home page
    Given I am on the home page
    When I inspect the home page
    Then the header should start with "Welcome"