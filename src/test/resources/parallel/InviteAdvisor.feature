@feature
Feature: Advisor Invitation Flow


  Background: 
  Given User is already logged in to application
  |username            |password    |
  |ashokmarch12@yopmail.com|Password@123|

  Scenario: Complete Advisor Invitation Flow

    Given I am on FamilyCentral Home Page
    When I click on the Advisor Module
    And I click on the Invite Advisor button
    And I enter advisor details and send the invitation
    And I navigate to Yopmail to check the received email
    And I check the received invite email
    And I accept the received invite
    And I Enter SighUp TPA Process
    #And I extract OTP from Smstome
    And I enter OTP and continue
    And I enter new password and continue
    Then I should see the invitation completed successfully