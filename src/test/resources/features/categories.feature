Feature: Validate Categories functionality test cases

  Scenario Outline: Verify categories has an items
    Given User on website homepage
    When User clicks on category <category> link from homepage
    Then User shows category <category> items list

    Examples:
      | category   |
      | CATEGORIES |
      | Phones     |
      | Laptops    |
      | Monitors   |
