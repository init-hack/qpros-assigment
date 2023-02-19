Feature: Validate Login functionality test cases

  Scenario: Verify login with valid credentials
    Given User on website homepage
    When User clicks login link from homepage
    And Login with username "ismail90" and password "ismail"
    And Clicks login button
    Then User navigated to homepage as logged in
