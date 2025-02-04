# Created by bramj at 04/02/2025
Feature: # Enter feature name here
  # Enter feature description here

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"