@feature
Feature: Account Page feature
  I want to use this template for my feature file
  
 Scenario: Accounts page title
 
  Given User is already logged in to application
  |username            |password    |
  |ashokmarch26@yopmail.com|Password@123|
 
  When User is on Accounts page
  And user gets the title of the page
  Then page title should be "https://www.familycentral.com"

 Scenario: Accounts section count
 
  Given User is already logged in to application
  |username            |password    |
  |ashokmarch12@yopmail.com|Password@123|
 
    #Given User is on Accounts pag
    
    When user gets account section
    |Sign up and create an account|
    |Add a family member|
    |Upload your profile pic|
    |Add an emergency contact|
    |Invite a trusted professional advisor|
    Then account section count should be 5