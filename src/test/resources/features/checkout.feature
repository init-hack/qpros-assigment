Feature: Validate Checkout functionality test cases

  Scenario: Verify checkout successfully
    Given User on website homepage
    And User clicks login link from homepage
    And Login with username "ismail90" and password "ismail"
    And Clicks login button
    And User navigated to homepage as logged in
    And User visits a random product details page
    And User clicks add to cart button
    And User clicks cart link to be redirected to cart page
    And User finds the product is added to cart
    When User clicks place order button
    And User fills name "Ismail Isleem"
    And User fills country, city with "Jordan", "Amman"
    And User fills credit card number "1234000022301100" year "2026" month "08"
    And User clicks purchase button
    Then System displays order purchased successfully text "Thank you for your purchase!"
