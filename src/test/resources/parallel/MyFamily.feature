@feature
Feature: Invite Family Member and Verify Invitation

 Background: 
  Given User is already logged in to application
  |username            |password    |
  |ashokmarch12@yopmail.com|Password@123|
  
  Scenario: Inviting a Family Member and Verifying Invitation Email
    
    Given User is on My Family Module
    When User clicks on AddMember
    Then User should see the PopUpWindow
    And User Enters the Invite Person Name
    And User Enters Invite Email Address
    And User Clicks on Send Invite
    Then User Should see the "Invite has been sent to email" Message
    When User Navigates to Yopmail

    And Check for Received Invite Email
    And User Switch to Email Iframe
    And User Click on Create Account
    And User Join Your Family
    And User Continue on NextPage1
    And User Enter Password and Confirm Password
    And User Continue on NextPage2
    And User Select Country, Enter Phone Number, and Send Code
    And User Verify OTP Element Presence
    And User Enter OTP
    And User Complete Registration
    And User Verify Home

#Scenario: Dummy Scenario
 #Given User is on Join family page
 #When User go through all clicks
 
  #@smoke
  #Scenario: Smoke Test - Invite and Registration
  #
    #Given User is on My Family Module
    #When User clicks on AddMember
    #Then User should see the PopUpWindow
    #And User Enters the Invite Person Name
    #And User Enters Invite Email Address
    #And User Clicks on Send Invite
    #Then User Should see the "Invite has been sent to email" Message
    #When User Navigates to Yopmail
#
    #And User Navigate to My Family Module
    #And User Click on AddMember
    #And User Verify PopUpWindow
    #And User Enter Invite Person Name and Email Address
    #And User Click on Send Invite
    #And User Verify "Invite has been sent to email" Message
    #And User Navigate to Yopmail
    #And User Check for Received Invite Email
    #And User Switch to Email Iframe
    #And User Click on Create Account
    #And User Join Your Family
    #And User Continue on Yopmail
    #And User Enter Password and Confirm Password
    #And User Continue on Yopmail
    #And User Select Country, Enter Phone Number, and Send Code
    #And User Verify OTP Element Presence
    #And User Enter OTP
    #And User Complete Registration
    #And User Verify Home

  
  
  