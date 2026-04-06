Feature: Navigation Links Smoke Suite
  As a user
  I want to verify that critical navigation links work
  So that core pages are always reachable

  @smoke
  Scenario: Verify Catalog link opens the collection page
    Given user is on the homepage
    When user clicks the Catalog link
    Then collection page should load

  @smoke
  Scenario: Verify Blog link opens the blog page
    Given user is on the homepage
    When user clicks the Blog link
    Then blog page should load

  @smoke
  Scenario: Verify left navigation About Us link opens the About page
    Given user is on the homepage
    When user clicks the left navigation About Us link
    Then about page should load


  @smoke
  Scenario: Verify Checkout link opens the cart page
    Given user is on the homepage
    When user clicks the cart link
    Then cart page should load

  @smoke
  Scenario: Verify footer Search link opens the search page
    Given user is on the homepage
    When user clicks the footer Search link
    Then search page should load

  @smoke
  Scenario: Verify footer About Us link opens the About Us page
    Given user is on the homepage
    When user clicks the footer About Us link
    Then about page should load