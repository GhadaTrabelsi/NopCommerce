@Login
Feature: Login

  Background:
    Given I am on the login page

  @valid-credentials
  Scenario: Login with valid credentials
    When I enter the email and password
    And I click the login button
    Then Page Title should be "Dashboard"
    When User click on Log out link
    Then Title of the page should be "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    

  @invalid-credentials
  Scenario Outline: Login with invalid credentials
    When I enter the email "<email>" and password "<password>"
    And I click the login button
    Then I should see an error message "Login was unsuccessful. Please correct the errors and try again."

    Examples:
      | email                      | password           |
      | adminxxxx@yourstore.com    | admin   	|
      | admin@yourstore.com        | incorrectpassword |