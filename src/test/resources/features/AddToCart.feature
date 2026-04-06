Feature: Cart Smoke Tests
  As a user
  I want to verify basic cart functionality
  So that I know the cart feature is working properly
  
  @smoke
  Scenario: Verify cart page loads and shows empty cart message
  Given user is on the Home page
  When user navigates to the cart page
  Then the empty cart message should be visible
 
  @smoke
  Scenario: Verify product page loads successfully
  Given user is on the Home page
  When user opens a product
  Then the product title, price, and Add to Cart button should be visible
 
  @smoke
  Scenario: Verify user can add a product to the cart
  Given user is on the Home page
  When user opens a product
  And  user adds the product to the cart
  And  the cart should show 1 item

  
