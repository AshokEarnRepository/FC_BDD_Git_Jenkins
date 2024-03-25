@feature
Feature: Calendar Event Creation with Recurring and Reminder Options
  
  
  Scenario: User Creates Monthly Recurring Calendar Event with Reminder
  
    Given User is already logged in to application
  |username            |password    |
  |ashokmarch12@yopmail.com|Password@123|
  
    When the user is on the Calendar page
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
