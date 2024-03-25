Feature: Google Search

  Scenario: Verify Google Title in Chrome
    Given I open Google Chrome browser
    When I navigate to the Google homepage
    Then I get the title of the page
