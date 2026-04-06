 
Feature: Home Page Smoke Tests
  As a user
  I want to verify the homepage loads correctly
  So that core UI elements are always available
 @smoke
  Scenario: Verify homepage loads with essential UI elements
    Given user navigates to the homepage
    Then left navigation panel should be visible
    And featured products section should be visible
    And each product card should be visible
    And product images should be visible
    And cart link should be visible
    And checkout link should be visible
    And footer should be visible