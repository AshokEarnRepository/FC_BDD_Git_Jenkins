Feature: Medical Document Management Feature


Background:
    Given user is on login page
    When user clicks on LandingPageLogin
    And user clicks on login option of families
    Then user should navigate to login page
    When user enters username as "nramya19@yopmail.com" into email field
    And user enters password as "Password@123" into password field
    And user clicks on login button
    Then user gets the family central page
    
     When the User clicks on Family Access Files
    And the User clicks on Medical folder
    And the User clicks on Subscriber
    And the User clicks on Vaccine Cards folder
    And the User clicks on Add option
    
    
#above steps for logging into the family central website.

  @Sanity
  Scenario: Add and Verify a Medical Document
  
    #Given the User is on the home page
    #When the User clicks on Family Access Files
    #And the User clicks on Medical folder
    #And the User clicks on Subscriber
    #And the User clicks on Vaccine Cards folder
    #And the User clicks on Add option
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
Scenario: User takes the picture
     
    And User clicks on the Take a picture option
    Then User accepts the allow pop up alert
    And User clicks on take a picture
    And User enters some text as File name
    And User cliks on the Save option
    #Then the User should see a success message "added successfully"
    @Skip
    Scenario: User uploads a file into VaccineCards folder
    Given User is on 
    