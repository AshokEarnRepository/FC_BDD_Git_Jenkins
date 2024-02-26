Feature: File Management Feature

  Scenario: Add a Custom Folder and Verify Success
  
  
    Given user is on login page
    When user clicks on LandingPageLogin
    And user clicks on login option of families
    Then user should navigate to login page
    When user enters username as "nramya19@yopmail.com" into email field
    And user enters password as "Password@123" into password field
    And user clicks on login button
    Then user gets the family central page
#above steps for logging into the family central website.

    #Given the User is on the home page
    When the User clicks on Family Access Files
    And the User clicks on Add Folder
    And the User enters the folder name as "customFolderOne" into Folder name field
    And the User clicks on the Add button
    Then the User should see a success popup with the message "added successfully"
    And the User clicks on close user guide
    #And the User verifies the added custom folder "customFolderOne"
    #And the User clicks and opens the folder "customFolderOne"



