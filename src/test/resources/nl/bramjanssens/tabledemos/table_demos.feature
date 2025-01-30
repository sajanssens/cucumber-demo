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
