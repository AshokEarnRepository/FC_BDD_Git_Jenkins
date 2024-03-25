@feature
Feature: Upload a file functionality into Photos and Videos

  #Background: 
    #Given User is already logged in to application
    #| username            | password    |
    #| ashokmarch12@yopmail.com | Password@123 |

  @run-together
  Scenario: Uploading a file using Add option under Photos videos
   Given User is already logged in to application
    | username            | password    |
    | ashokmarch12@yopmail.com | Password@123 |
  
    When User is on Home page
    And User clicks on Photos and Videos Section
    And User clicks on Family Member
    And User clicks on Add button
    When User uploads a file from the device
    Then User should see the Uploaded Successfully Toast Message

  @run-together
  Scenario: Uploading a file using Click to Upload
    Given User is on Home page
    When User clicks on Photos and Videos Section
    And User clicks on Family Member
    And User clicks on Upload Icon
    When User uploads a file from the device
    Then User should see the Uploaded Successfully Toast Message

  @run-together
  Scenario: User Adds a Folder Under Subscriber Folder and Uploads a File into the New Folder
    Given User is on Home page
    When User clicks on Photos and Videos Section
    When User clicks on Subscriber Folder
    And User clicks on Add Option Button
    And User clicks on New Folder from DropDown
    And User enters the Folder name
    And User clicks on the Submit button or Add
    Then User should see the Successfully Added Message
    And User closes the Pop up Message
    Then User should see the added Folder Name
    And User clicks the added folder
    And User uploads a file into the folder
    Then User should see the Uploaded Successfully Toast Message
