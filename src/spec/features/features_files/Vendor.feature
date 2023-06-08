@Vendor
Feature: 

  Background: Below are the common steps for each scenario
    Given I am on the login page
    When I enter the email and password
    And I click the login button
    Then Page Title should be "Dashboard"
    When User click on customers Menu

  Scenario: Add new Vendor
    And click on vendors Menu Item
    And click on Add new vendor button
    Then User can view Add new vendor page
    When User enter vendor info
    And click on Save button for vendor
    Then User can view confirmation message for vendor "For security purposes, the feature you have requested is not available on the demo site."

  Scenario: Search  Vendor by EmailID
    And click on vendors Menu Item
    And Enter vendor Email
    When Click on search vendor button
    Then User should find Email of vendor in the search table

  Scenario: Search  Vendor by Name
    And click on vendors Menu Item
    And Enter vendor Name
    When Click on search vendor button
    Then User should find Name  of vendor in the search table
