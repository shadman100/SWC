Feature: Home Page Functionality
    
  Scenario: Test for writing a post
   	Given I go to SocialWareApp
   	And I enter landing page "Username"
   	And I enter landing page "Password"
   	And I click landing page "Login button"
   	And I write a post
   	And I click home page "Post button"
   	Then I validate the post is present
   	
   Scenario: Test the footer links
   	Given I go to SocialWareApp
   	And I enter landing page "Username"
   	And I enter landing page "Password"
   	And I click landing page "Login button"
   	Then I validate the home page footer links
   	