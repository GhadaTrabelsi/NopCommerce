@Manufacturers
Feature: Manufacturers

  Background: Below are the common steps for each scenario
    Given I am on the login page
    When I enter the email and password
    And I click the login button
    Then Page Title should be "Dashboard"

  Scenario: Add a New Manufacturer
    When User click on catalog menu
    And click on Manufacturers
    And Click on Add New button
    Then User can view "Add a new manufacturer"
    When user enter Manufacturer info
    And Click on Save button
    Then User can view Manufacturer added confirmation message "The new manufacturer has been added successfully."

  Scenario: Search Manufacturer by Name
    When User click on catalog menu
    And click on Manufacturers
    And Enter Manufacturer Name
    When Click on Manufacturer Search button
    Then User should found Manufacturer Name in the search table
   
