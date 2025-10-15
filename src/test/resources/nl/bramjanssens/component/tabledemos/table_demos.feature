Feature: Species counter
  It's important to know how many species still live on planet earth.

  Scenario: Count number of species
    Given the following animals:
      | cow   |
      | horse |
      | sheep |
      | cow   |
    When I count the number of different species
    Then It should be 3

  Scenario: Count number of animals
    Given the following animal count:
      | cow   | 2   |
      | horse | 3   |
      | sheep | 100 |
      | cow   | 3   |
    When I count the number of animals
    Then It should be 108

  Scenario: Count number of animals
    Given the following table of animals:
      | animal | count |
      | cow    | 2     |
      | horse  | 3     |
      | sheep  | 100   |
      | cow    | 3     |
    When I count the number of animals in this table
    Then It should be 108


  Scenario: Count number of animals
    Given the following animal counts:
      | animal | count |
      | cow    | 2     |
      | horse  | 3     |
      | sheep  | 100   |
      | cow    | 3     |
    When I sum the numbers
    Then It should be 108


  Scenario: Add products to basket 0
    Given I have an empty basket
    When I add these single column rows:
      | banana |
      | carrot |
      | tv     |
    Then It should contain 3 products

  Scenario: Add products to basket 1
    Given I have an empty basket
    When I add these single column products:
      | banana |
      | carrot |
      | tv     |
    Then It should contain 3 products

  Scenario: Add products to basket 2
    Given I have an empty basket
    When I add these product rows with header:
      | name   |
      | banana |
      | carrot |
      | tv     |
    Then It should contain 3 products

  Scenario: Add products to basket 3
    Given I have an empty basket
    When I add these order line rows with header:
      | name   | qty |
      | banana | 2   |
      | carrot | 3   |
      | tv     | 4   |
    Then It should contain 9 products

  Scenario: Add products to basket 4
    Given I have an empty basket
    When I add these order lines with header:
      | name   | qty |
      | banana | 2   |
      | carrot | 3   |
      | tv     | 4   |
    Then It should contain 9 products