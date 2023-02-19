Feature: Validate Cart functionality test cases

  Background: Login user to the system
    Given User on website homepage
    When User clicks login link from homepage
    And Login with username "ismail90" and password "ismail"
    And Clicks login button
    Then User navigated to homepage as logged in

  Scenario: Verify adding a product to cart successfully
    Given User visits a random product details page
    When User clicks add to cart button
    And User clicks cart link to be redirected to cart page
    Then User finds the product is added to cart

  Scenario: Verify deleting a product from cart successfully
    Given User clicks cart link to be redirected to cart page
    When User deletes a product from cart
    Then Product is removed from cart
