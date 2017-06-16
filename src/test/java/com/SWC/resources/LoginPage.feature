Feature: Login Page Functionality

  Scenario: Test for login with valid credentials
    Given I go to SocialWareApp
    And I enter landing page "Username"
    And I enter landing page "Password"
    When I click landing page "Login button"
    Then I validate "Logout" text
    
  Scenario: Test for registration with valid credentials
   	Given I go to SocialWareApp
   	And I enter landing page "Email"
   	And I enter landing page "Reg. Password"
   	And I enter landing page "Confirm Password"
   	And I click landing page "I agree box"
   	When I click landing page "Submit button"
   	Then I validate "Name Label" text


    
