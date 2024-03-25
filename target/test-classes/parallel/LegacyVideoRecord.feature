@feature
Feature: Legacy Video Record

  Background: 
  Given User is already logged in to application
  |username            |password    |
  |ashokmarch12@yopmail.com|Password@123|

  Scenario: Legacy Video Record Workflow
  
    Given the user is on the Legacy Messages page
    When the user extracts OTP from smstome
    And the user clicks on Create your first message button
    And the user click on the record One Here link
    And the user clicks on Record video message button
    And the user clicks on Record now button
    And the user starts recording
    And the user stops recording
    And the user clicks on Next button
    And the user enters message title
    And the user clicks on Next button after entering message title
    And the user clicks on My Family
    And the user selects all checkboxes
    And the user clicks on Next button
    And the user clicks on the Specific date label
    #And the user selects specific date "2024", "March", "4"
    And the user selects random year
    And the user selects random month
    And the user selects random day
    And the user clicks on Next button
    Then User should see the Updated Successfully message
    
    And the user clicks on the selected video
    And the user clicks on Close button
    Then the user should see the Legacy Message title

  # Add more scenarios or examples as needed...
