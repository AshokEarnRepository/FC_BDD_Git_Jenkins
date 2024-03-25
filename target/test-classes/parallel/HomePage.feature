@feature
Feature: Verify DashBoard Let's get started Section



 Background: 
  Given User is already logged in to application
  |username            |password    |
  |ashokmarch12@yopmail.com|Password@123|

  Scenario: Verify Lets get started Section and perform actions
    Given user is on home page
    When Verify the Are you ready to start your day?
    And User is on My Family Module
    When User clicks on AddMember
    Then User should see the PopUpWindow
    And User Enters the Invite Person Name
    And User Enters Invite Email Address
    And User Clicks on Send Invite
    Then User Should see the "Invite has been sent to email" Message2
    And User Clicks on home page
    And User clicks on Your family tab
    Then User should see the Added FamilyMember

  #Scenario: Verify different actions if "Are you ready to start your day?" text is displayed
    #Given user is on home page
    #When Verify the Let's get started Section is visible
    #And If "Are you ready to start your day?" text is displayed perform different actions
    #When User clicks on Invite your Advisors
    #And User clicks on the Invite option to invite a TPA
    #Then User Clicks on home page
    #And User clicks on Trusted Professional Advisor tab
    #And User verifies the TPA Names from the list
    #Then User should see the TPA added name under Trusted professional section
    #And Verify the exact match with the added TPA