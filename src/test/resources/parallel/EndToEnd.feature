
Feature: End to End Flow in one browser
  I want to use this template for my feature file

 Background: 
  Given User is already logged in to application
  |username            |password    |
  |ashokmarch1@yopmail.com|Password@123|

  
Scenario: End to End Flow in one browser

    
    
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
    
    
  
    
    
     When the User clicks on Family Access Files
    And the User clicks on Medical folder
    And the User clicks on Subscriber
    And the User clicks on Vaccine Cards folder
    And the User clicks on Add option
    
    And the User clicks on New document to create a document
    And the User enters "Doc_one" into Enter a document name
    And the User clicks on Next Button
    And the User clicks and Enter some text in the field
    And the User clicks on Save Button
    Then the User should see a success message "added successfully"
    
    #When the User clicks on Family Access Files
    #And the User clicks on Medical folder
    #And the User clicks on Subscriber
    #And the User clicks on Vaccine Cards folder
    And the User clicks on Add option
    And User clicks on the Take a picture option
    Then User accepts the allow pop up alert
    And User clicks on take a picture
    And User enters some text as File name
    And User cliks on the Save option
    
    #And User clicks on EmergencyPrep
    When the User clicks on Family Access Files
    And the User clicks on Add Folder
    And the User enters the folder name as "customFolderOne" into Folder name field
    And the User clicks on the Add button
    Then the User should see a success popup with the message "added successfully"
    And the User clicks on close user guide
    
    
   
  #@tag1
  #Scenario: Uploading a file using Add option under Photos videos
  
    Given User is on Home page
    When User clicks on Photos and Videos Section
    And User clicks on Family Member
    And User clicks on Add button
    When User uploads a file from the device
    Then User should see the Uploaded Successfully Toast Message
    
#@tag2
 #Scenario: Uploading a file using Click to Upload
 
    Given User is on Home page
    When User clicks on Photos and Videos Section
    And User clicks on Family Member
    And User clicks on Upload Icon
    When User uploads a file from the device
    Then User should see the Uploaded Successfully Toast Message
    
     
 #@tag3
 #Scenario: User Adds a Folder Under Subscriber Folder and Uploads a File into the New Folder
 
    Given User is on Home page
    When User clicks on Photos and Videos Section
    When User clicks on Subscriber Folder
    And User clicks on Add Option Button
    And User clicks on New Folder from DropDown
    And User enters the Folder name
    And User clicks on the Submit button or Add
    Then User should see the Successfully Added Message
    And User closes the Pop up Message
    
    And User go back and click Home
    
    #Then User should see the added Folder Name
    And User clicks the added folder
    And User uploads a file into the folder
    Then User should see the Uploaded Successfully Toast Message
    
    
    
   #Scenario: User Creates Monthly Recurring Calendar Event with Reminder
  
    Given the user is on the Calendar page
    When the user clicks on New Event
    And User enters "Event001" into EventTitle
    And selects the start date on the calendar
    And User sets the start time to "01:00"
    And User sets the end time to "14:00"
    And chooses to set a recurring event
    And User sets the recurrence to Monthly
     And selects the End date on the calendar
    #And User selects the specific day "28"
    #And User chooses the year "2025"
    #And User sets a reminder for "5 min before"
    And assigns the event to family member
    And enters someText into the description
    And clicks on save
    Then the user should see the message "Your event has been created"
    #And the calendar should display the newly created monthly recurring event

    
    
   #Scenario: Legacy Video Record Workflow
  
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
    
    #Scenario: General Legal upload PNG file upload
    
   Given User clicks on personal vault
   And User navigates to smstome website

  When user clicks on general legal information
  And user clicks on add option
  And user clicks on upload file
  Then User should see the "File Uploaded Successfully" Message
    
     #Scenario: General Legal upload PDF file upload
    Given User clicks on personal vault
    #And User navigates to smstome website
  
  #General Legal Information
  When user clicks on general legal information
  And user clicks on add option
  And user clicks on upload file1
  Then User should see the "Uploaded Successfully" Message
  
  
  #Scenario: General Legal upload JPG file uploa
  
    Given User clicks on personal vault
    #And User navigates to smstome website
  
  When user clicks on general legal information
  And user clicks on add option
  And user clicks on upload file2
  Then User should see the "Uploaded Successfully" Message
  
  
  #@tag3
  
  
    #Scenario: General Legal upload XLSX file uploa
    
   Given User clicks on personal vault
    #And User navigates to smstome website
  
  #General Legal Information
  When user clicks on general legal information
  And user clicks on add option
  And user clicks on upload file3
  Then User should see the "Uploaded Successfully" Message
  
  
  #@tag4
 
    #Scenario: General Legal upload JPEG file uploa
    
    Given User clicks on personal vault
    #And User navigates to smstome website
  
  #General Legal Information
  When user clicks on general legal information
  And user clicks on add option
  And user clicks on upload file4
  Then User should see the "Uploaded Successfully" Message
  
  
  
  #@tag5
    #Scenario: General Legal upload TXT file upload
    
    Given User clicks on personal vault
    #And User navigates to smstome website
  
  #General Legal Information
  When user clicks on general legal information
  And user clicks on add option
  And user clicks on upload file5
  Then User should see the "Uploaded Successfully" Message