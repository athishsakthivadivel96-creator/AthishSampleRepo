Feature: OrangeHRM Login

Scenario: Positive Login
  Given user is in OrangeHRM login page
  When user enters valid username and password
  Then user should see the dashboard page

Scenario: Negative Login
  Given user is in OrangeHRM login page
  When user enters invalid username and password
  Then error message should be displayed
