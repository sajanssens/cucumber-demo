Feature: Looking for cheese

  @browser
  Scenario: Finding some cheese on google
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "Cheese"