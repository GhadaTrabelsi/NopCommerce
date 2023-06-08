@Customer
Feature: 

  Background: Below are the common steps for each scenario
    Given I am on the login page
    When I enter the email and password
    And I click the login button
    Then Page Title should be "Dashboard"

  Scenario: Add new Customer
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."

  Scenario: Search  Customer by EmailID
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer Email
    When Click on search button
    Then User should find Email in the search table

  Scenario: Search  Customer by Name
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should find Name in the search table
