Feature: I want to login with Facebook to n11

  @facebook_login
  Scenario: Facebook login
    Given I launch browser and am on the main page
    When I choose to login with Facebook
    Then I enter valid credentials
    And I should be logged in successfully