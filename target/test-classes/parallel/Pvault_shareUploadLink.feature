@feature
Feature: Personal Vault Share Upload

 Background: 
  Given User is already logged in to application
  |username            |password    |
  |ashokmarch12@yopmail.com|Password@123|

Scenario: Share upload link functionality

    Given User clicks on personal vault
    And User navigates to smstome website
    When User shares an email
    Then User goes to the appropriate email
    Then User navigates to the yopmail and opens the website
    And User opens the email and signs in
    And User enters the authentication code
    And User uploads the file
