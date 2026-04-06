Feature: SauceDemo Signup (Demo Simulation)

@smoke @regression
Scenario: User tries to signup
  Given the user is on the login page
  When the user enters invalid username and password
  Then the user should see an error message