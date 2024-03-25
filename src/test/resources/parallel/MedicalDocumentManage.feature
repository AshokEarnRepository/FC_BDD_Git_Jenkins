@feature
Feature: Medical Document Management Feature


  Background: 
  Given User is already logged in to application
  |username            |password    |
  |ashokmarch12@yopmail.com|Password@123|
    
     When the User clicks on Family Access Files
    And the User clicks on Medical folder
    And the User clicks on Subscriber
    And the User clicks on Vaccine Cards folder
    And the User clicks on Add option
    
    
#above steps for logging into the family central website.

  @Sanity
  Scenario: Add and Verify a Medical Document
  
    And the User clicks on New document to create a document
    And the User enters "Doc_one" into Enter a document name
    And the User clicks on Next Button
    And the User clicks and Enter some text in the field
    And the User clicks on Save Button
    Then the User should see a success message "added successfully"
    
    #And the User clicks on "Doc_one"
    #And the User verifies the text after opening "Uploaded: Feb 22, 2024"
    #And the User clicks on Close button
@Skip
	Scenario: User takes the picture functionality
     
    And User clicks on the Take a picture option
    Then User accepts the allow pop up alert
    And User clicks on take a picture
    And User enters some text as File name
    And User cliks on the Save option
    #Then the User should see a success message "added successfully"
    #Scenario: User uploads a file into VaccineCards folder
    