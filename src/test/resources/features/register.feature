Feature: Validate Registration functionality test cases

  Scenario: Verify Register with valid credentials
    Given User on website homepage
    When User clicks SignUp link from homepage
    And Registers username "ismail[random]" with password "ismail"
    And Clicks Register button
    Then User shows alert popup with text "Sign up successful."
    And User closes alert popup
    And User navigated to homepage
