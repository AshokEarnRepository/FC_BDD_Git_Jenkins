#@feature
Feature: login page feature
  
  
  Scenario: Login page title

    Given user is on landing page
    When user gets the title of the page
    
 @login
  Scenario: Login with valid credentials
    
    Given user is on landing page
    When user clicks on LandingPageLogin
    And user clicks on login option of families
    Then user should navigate to login page
    When user enters username as "ashokmarch12@yopmail.com" into email field
    And user enters password as "Password@123" into password field
    And user clicks on login button
    Then user gets the family central page
    And page title should be "https://www.familycentral.com"