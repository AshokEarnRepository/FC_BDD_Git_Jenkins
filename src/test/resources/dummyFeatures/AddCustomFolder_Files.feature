@feature
Feature: Files Add Custom Folder and Uploading Files in it

  @pdf
  Scenario: Add a Custom Folder and Upload PDF Files of Small, Medium and Large init
  
  #Given User is already logged in to application
  #|username            |password    |
  #|ashokmarch12@yopmail.com|Password@123|
  
    Given the User clicks on Family Access Files
    When the User clicks on Add Folder
    And the User enters the folder name into Folder name field
    And the User clicks on the Add button
    Then the User should see a success popup with the message "added successfully"
    And the User clicks on close user guide
    And the User verifies the added custom folder
    And the User clicks and opens the folder
    And User uploads PDF file into the that specific folder
   
   @docx 
  Scenario: Add a Custom Folder and Upload DOCX Files of Small, Medium and Large init
  
    Given the User clicks on Family Access Files
    When the User clicks on Add Folder
    And the User enters the folder name into Folder name field
    And the User clicks on the Add button
    Then the User should see a success popup with the message "added successfully"
    And the User clicks on close user guide
    And the User verifies the added custom folder
    And the User clicks and opens the folder
    And User uploads DOCX file into the that specific folder
    
    @txt
 Scenario: Add a Custom Folder and Upload TXT Files of Small, Medium and Large init
  
    Given the User clicks on Family Access Files
    When the User clicks on Add Folder
    And the User enters the folder name into Folder name field
    And the User clicks on the Add button
    Then the User should see a success popup with the message "added successfully"
    And the User clicks on close user guide
    And the User verifies the added custom folder
    And the User clicks and opens the folder
    And User uploads TXT file into the that specific folder
    
    @xlsx
 Scenario: Add a Custom Folder and Upload XLSX Files of Small, Medium and Large init
  
    Given the User clicks on Family Access Files
    When the User clicks on Add Folder
    And the User enters the folder name into Folder name field
    And the User clicks on the Add button
    Then the User should see a success popup with the message "added successfully"
    And the User clicks on close user guide
    And the User verifies the added custom folder
    And the User clicks and opens the folder
    And User uploads XLSX file into the that specific folder
    
    @png
 Scenario: Add a Custom Folder and Upload PNG Files of Small, Medium and Large init
  
    Given the User clicks on Family Access Files
    When the User clicks on Add Folder
    And the User enters the folder name into Folder name field
    And the User clicks on the Add button
    Then the User should see a success popup with the message "added successfully"
    And the User clicks on close user guide
    And the User verifies the added custom folder
    And the User clicks and opens the folder
    And User uploads PNG file into the that specific folder
    
    @jpg
  Scenario: Add a Custom Folder and Upload JPG Files of Small, Medium and Large init
  
    Given the User clicks on Family Access Files
    When the User clicks on Add Folder
    And the User enters the folder name into Folder name field
    And the User clicks on the Add button
    Then the User should see a success popup with the message "added successfully"
    And the User clicks on close user guide
    And the User verifies the added custom folder
    And the User clicks and opens the folder
    And User uploads JPG file into the that specific folder
    
    @mp4
 Scenario: Add a Custom Folder and Upload MP4 Files of Small, Medium and Large init
  
    Given the User clicks on Family Access Files
    When the User clicks on Add Folder
    And the User enters the folder name into Folder name field
    And the User clicks on the Add button
    Then the User should see a success popup with the message "added successfully"
    And the User clicks on close user guide
    And the User verifies the added custom folder
    And the User clicks and opens the folder
    And User uploads MP4 file into the that specific folder 

#Scenario: Adding All file formats jpg, png, jpeg, docx, txt, mp4 in one folder

