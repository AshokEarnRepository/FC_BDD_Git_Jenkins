@feature
Feature: Account Page feature
  I want to use this template for my feature file
  
  Background: 
  Given User is already logged in to application
  |username            |password    |
  |ashokmarch12@yopmail.com|Password@123|

 Scenario: Accounts page title
 
 Given User is on Accounts page
 When user gets the title of the page
 Then page title should be "https://www.familycentral.com"
 
 Scenario: Accounts section count
 
    Given User is on Accounts page
    When user gets account section
    |Sign up and create an account|
    |Add a family member|
    |Upload your profile pic|
    |Add an emergency contact|
    |Invite a trusted professional advisor|
    Then account section count should be 5
   

  #Given user is on login page
    #When user clicks on LandingPageLogin
    #And user clicks on login option of families
    #Then user should navigate to login page
    #When user enters username as "nramya19@yopmail.com" into email field
    #And user enters password as "Password@123" into password field
    #And user clicks on login button
    #Then user gets the family central page
#above steps for logging into the family central website.