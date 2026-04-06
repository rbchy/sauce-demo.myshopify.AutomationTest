Feature: Search Smoke Tests
  As a shopper
  I want to use the search functionality
  So that I can quickly find products on the store

  @smoke
Scenario: Search bar is visible and accepts input
  Given I am on the home page
  Then the search bar should be visible
  When I type into the search bar
  Then the search input should contain the typed value

  @smoke
  Scenario: Valid search returns results
    Given I am on the home page
    When I search for "Noir Jacket"
    Then search results should be displayed
    And at least one product should be visible

  @smoke
  Scenario: Invalid search shows no results message
    Given I am on the home page
    When I search for "Blue Shade"
    Then a no results message should be displayed
    And no products should be visible

  @smoke
  Scenario: Clicking a search result opens product details page
    Given I am on the home page
    When I search for "Noir Jacket"
    And I click the first product in search results
    Then the product details page should be displayed
  