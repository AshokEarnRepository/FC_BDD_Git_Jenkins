@feature
Feature: Share Feedback

  Background: 
    Given User is already logged in to application
    | username                  | password    |
    | ashokmarch12@yopmail.com | Password@123 |

  @tag0
  Scenario: Verify Share Feedback Functionality with Text, Email, and Phone Verification
  
    When user clicks on Share Feedback
    Then user should see the Tell us how we can improve Family Central text
    Then user should verify email is present in Share Feedback section
    Then user should verify phone number is present in Share Feedback section
    When user enters description
    And user clicks on Send button
    Then user verifies PopUpText and SuccessMessage
