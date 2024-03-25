Feature: Account Menu Functionality


Scenario: Account Menu Functionality of pwd change and Executor and Emergency contact

Given User is already logged in to application
  |username            |password    |
  |ashokmarch12@yopmail.com|Password@123|

    When user clicks on the account memu
    Then user clicks on the my accounts
    Then user clicks on the edit option 
    And user modify the data and clicks on save option
    Then user clicks on Password
    And user enters the current password
    And user enters the new password and confirm password
    Then user clicks on savechanges
    And user clicks on executor
    Then user enters the first name and lastname
    And user enters the email and phone number
    Then user sends the invitation to the executor
    When user clicks on emergency contact
    Then user enters firstname and last name
    Then user enters the email and emergency phone number
    And user clicks on send