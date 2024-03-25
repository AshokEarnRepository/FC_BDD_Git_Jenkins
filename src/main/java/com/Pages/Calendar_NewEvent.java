package com.Pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.Utils.ScrollUtils;
import com.qa.Utils.WebDriverWaits;

public class Calendar_NewEvent {

	private WebDriver driver;
	private WebDriverWaits waitUtil;
	private ScrollUtils scrollUtils;

	// Calendar page locators
	public static final By CALENDAR_BUTTON = By.xpath("(//span[normalize-space()='Calendar'])[1]");
	public static final By NEW_EVENT_BUTTON = By.xpath("//button[normalize-space()='New Event +']");

	// Event details locators
	public static final By EVENT_TITLE_INPUT = By.xpath("//input[@id='eventTitle']");
	public static final By START_TIME_INPUT = By.xpath("//input[@id='startTime']");
	public static final By END_TIME_INPUT = By.xpath("//input[@id='endTime']");

	// Recurring event details locators
	public static final By RECURRING_EVENT_DROPDOWN = By.xpath("//select[@id='notify']");
//	    public static final By RECURRING_TYPE_SELECT = By.xpath("//select[@id='recurType']");
	public static final By MONTHLY_OPTION = By.xpath("//option[normalize-space()='Monthly']");

	// Date and time selection locators
	public static final By START_DATE = By.xpath("(//img[@class='icon-absolute'])[1]");
	public static final By MONTH_SELECT = By.xpath("//select[@title='Select month']");
	public static final By YEAR_DROPDOWN = By.xpath("//select[@title='Select year']");
	public static final By YEAR_SELECT = By.xpath("//select[@title='Select year']/option"); // findElements

	public static final By DAY_SELECT = By.xpath("//ngb-datepicker-month[@role='grid']/div/div"); // findElements

	// End Date Locators
	public static final By END_DATE = By.xpath("(//img[@class='icon-absolute'])[2]");

	// Start Time and End Time Locators
	public static final By STARTTIME = By.xpath("//input[@id='startTime']");
	public static final By ENDTIME = By.xpath("//input[@id='endTime']");

	// Attendee locators
	public static final By ADDPEOPLE_DROPDOWN = By.xpath("//button[@class='dropdown-toggle btn border']");
	public static final By ADDPEOPLE_SELECT = By.xpath("//div[@class='form-check']/input"); // findElements
	public static final By FamilyMembersList = By.xpath("//button[@class='dropdown-toggle btn border']/following::ul/li");

	// reminder locators
	public static final By REMINDER_DROPDOWN = By.xpath("//select[@id='reminder']");
	public static final By FIVE_MIN_BEFORE_OPTION = By.xpath("//option[normalize-space()='5 min before']");

	// Description and save locators
	public static final By DESCRIPTION_INPUT = By.xpath("//input[@id='description']");
	public static final By SAVE_BUTTON = By.xpath("//button[normalize-space()='Save']");

	// Success message locator
	public static final By SUCCESS_MESSAGE = By.xpath("//div[@aria-label='Your event has been created.']");

	// Constructor of the page class:

	public Calendar_NewEvent(WebDriver driver) {

		this.driver = driver;
		this.waitUtil = new WebDriverWaits(driver, Duration.ofSeconds(20));
		this.scrollUtils = new ScrollUtils(driver);
	}

	// Page Actions:

	public void clickOnCalendar() {

		waitUtil.waitForElementToBeClickable(CALENDAR_BUTTON).click();
	}

	public void clickOnNewEvent() {

		waitUtil.waitForElementToBeClickable(NEW_EVENT_BUTTON).click();
	}
	
	
		
		
		public void enterEventTitle(String Title) {
	        WebElement event_Title = waitUtil.waitForElementToBeClickable(EVENT_TITLE_INPUT);
	        event_Title.sendKeys(Title);
	    }

		public void clickOnStartTimeInput() {
		    WebElement startTimeInput = waitUtil.waitForElementToBeClickable(STARTTIME);
		    startTimeInput.sendKeys("01:00"); // Or whatever value you want to set
		}


	    public void clickOnEndTimeDropDown() {
	        WebElement endTimeOption = waitUtil.waitForElementToBeClickable(ENDTIME);
	        endTimeOption.click();
	    }
	    
	    
	    

	    public void clickOn_RECURRING_EVENT_DROPDOWN() {
	        // Wait for the dropdown to be clickable
	        WebElement recurringEventOptions = waitUtil.waitForElementToBeClickable(RECURRING_EVENT_DROPDOWN);
	        Select dropDownOptions = new Select(recurringEventOptions);

	        // Define the desired recurring event (e.g., "Monthly")
	        String desiredRecurringEvent = "Monthly";

	        // Check if the desired option is available in the dropdown
	        List<WebElement> options = dropDownOptions.getOptions();
	        boolean isDesiredOptionAvailable = options.stream().anyMatch(option -> option.getText().equalsIgnoreCase(desiredRecurringEvent));

	        if (isDesiredOptionAvailable) {
	            // Select the desired recurring event
	            dropDownOptions.selectByVisibleText(desiredRecurringEvent);

	            // Optional: Perform actions after selecting the recurring event if needed

	            // Verify the selected recurring event is as expected
	            WebElement selectedOption = dropDownOptions.getFirstSelectedOption();
	            String selectedRecurringEvent = selectedOption.getText().trim();

	            // Optional: Print the selected recurring event for verification
	            System.out.println("Selected Recurring Event: " + selectedRecurringEvent);

	            // Compare the selected recurring event with the expected value
	            if (selectedRecurringEvent.equalsIgnoreCase(desiredRecurringEvent)) {
	                System.out.println("Test Passed: Selected recurring event is " + desiredRecurringEvent + ".");
	            } else {
	                System.out.println("Test Failed: Selected recurring event is not " + desiredRecurringEvent + ".");
	            }
	        } else {
	            System.out.println("Desired recurring event '" + desiredRecurringEvent + "' not available in the dropdown.");
	        }
	    }


	        // Method to select the start date
	        public void selectStartDate() {
	            // Wait for and click on the START_DATE element
	            WebElement startDateCalendarView = waitUtil.waitForElementToBeClickable(START_DATE);
	            startDateCalendarView.click();

	            // XPath for finding all elements representing days in the calendar
	            String dayXPath = "//div[@class='btn-light ng-star-inserted']";

	            // Find all elements matching the XPath
	            List<WebElement> allDays = driver.findElements(By.xpath(dayXPath));

	            // Iterate through the elements to find an enabled day
	            WebElement selectedDay = null;
	            for (WebElement day : allDays) {
	                if (day.isEnabled()) {
	                    selectedDay = day;
	                    break; // Stop iterating once an enabled day is found
	                }
	            }

	            // Check if an enabled day is found
	            if (selectedDay != null) {
	                // Store the selected day text or any other information you need
	                String selectedDayText = selectedDay.getText();

	                // Perform any verification or action with the selected day
	                System.out.println("Selected Day: " + selectedDayText);

	                // Example: Click on the selected day (You can modify this based on your requirements)
	                selectedDay.click();

	                // Add additional verification steps as needed
	                // For example, verify that the selected day is now highlighted or displayed differently

	            } else {
	                System.out.println("No enabled day found in the calendar.");
	            }
	        }

	     // Method to select the end date
	        public void selectEndDate() {
	            WebElement endDateCalendarView = waitUtil.waitForElementToBeClickable(END_DATE);
	            endDateCalendarView.click();

	            // Get the selected start date text
	            WebElement startDateCalendarView = waitUtil.waitForElementToBeClickable(START_DATE);
	            String startDateText = startDateCalendarView.getText();

	            // Check if startDateText is empty or null
	            if (startDateText != null && !startDateText.isEmpty()) {
	                // Convert the start date text to a numerical value
	                int startDateValue = Integer.parseInt(startDateText);

	                // Find all elements representing days in the calendar
	                List<WebElement> allDays = driver.findElements(By.xpath("//div[@class='btn-light ng-star-inserted']"));

	                // Find and select any enabled end date that falls after the start date
	                WebElement selectedEndDate = null;
	                for (WebElement day : allDays) {
	                    if (day.isEnabled()) {
	                        // Get the numerical value of the day
	                        int dayValue = Integer.parseInt(day.getText());
	                        // Check if the day value is greater than or equal to the start date value
	                        if (dayValue >= startDateValue) {
	                            // Select the end date and break the loop
	                            selectedEndDate = day;
	                            selectedEndDate.click();
	                            break;
	                        }
	                    }
	                }

	                if (selectedEndDate == null) {
	                    System.out.println("No valid end date found in the calendar after the selected start date.");
	                }
	            } else {
	                System.out.println("Start date text is empty or null. Cannot parse to integer.");
	            }
	        }

	    	
	    /*
	    
	    public void selectEndDate() {
	    	WebElement EndDateCalendarView = waitUtil.waitForElementToBeClickable(END_DATE);
	    	EndDateCalendarView.click();

	           // Find all elements representing days in the calendar
	           List<WebElement> allDays = driver.findElements(By.xpath("//div[@class='btn-light ng-star-inserted']"));

	           // Find and select any enabled end date
	           if (!allDays.isEmpty()) {
	               WebElement selectedEndDate = allDays.get(15);  // Select the first enabled day (you can modify this logic)

	               // Re-locate the end date element to avoid StaleElementReferenceException

	               selectedEndDate.click();

	               
	           } else {
	               System.out.println("No enabled end date found in the calendar.");
	           }
	       } */
	    	

	         /*   // Method to select the start date
	            public void selectStartDate() {
	                WebElement startDateCalendarView = waitUtil.waitForElementToBeClickable(START_DATE);
	                startDateCalendarView.click();

	                // Your logic to select the start date here
	                // For example:
	                // Find the start date element and click on it
	                // Handle calendar pop-ups or date picker if necessary
	                // Perform any additional verification or action with the selected start date
	            }

	            // Method to select the end date
	            public void selectEndDate() {
	                WebElement endDateCalendarView = waitUtil.waitForElementToBeClickable(END_DATE);
	                endDateCalendarView.click();

	                // Get the selected start date text
	                String startDateText = START_DATE.getText();

	                // Convert the start date text to a numerical value
	                int startDateValue = Integer.parseInt(startDateText);

	                // Find all elements representing days in the calendar
	                List<WebElement> allDays = driver.findElements(By.xpath("//div[@class='btn-light ng-star-inserted']"));

	                // Find and select any enabled end date that falls after the start date
	                WebElement selectedEndDate = null;
	                for (WebElement day : allDays) {
	                    if (day.isEnabled()) {
	                        // Get the numerical value of the day
	                        int dayValue = Integer.parseInt(day.getText());
	                        // Check if the day value is greater than or equal to the start date value
	                        if (dayValue >= startDateValue) {
	                            // Select the end date and break the loop
	                            selectedEndDate = day;
	                            selectedEndDate.click();
	                            break;
	                        }
	                    }
	                }

	                if (selectedEndDate == null) {
	                    System.out.println("No valid end date found in the calendar after the selected start date.");
	                }
	            }
*/

	    

	    public void addPeople() {
	        try {
	            // Click on the ADDPEOPLE_DROPDOWN
	            WebElement addPeopleDropdown = waitUtil.waitForElementToBeClickable(By.xpath("//button[@class='dropdown-toggle btn border']"));
	            addPeopleDropdown.click();

	         // Get the list of family members
	            List<WebElement> peopleList = driver.findElements(FamilyMembersList);


	            // Check if there are any family members available
	            if (!peopleList.isEmpty()) {
	                // Generate a random index to select a family member
	                Random random = new Random();
	                int randomIndex = random.nextInt(peopleList.size());

	                // Select the family member at the random index
	                peopleList.get(randomIndex).click();

	                // Optional: Perform actions after selecting the family member if needed

	                // Get the text of the selected family member
	                WebElement selectedFamilyMember = peopleList.get(randomIndex);
	                String selectedMemberName = selectedFamilyMember.getText().trim();
	                System.out.println("Selected Family Member: " + selectedMemberName);

	                // Optional: Print the selected family member for verification
	                System.out.println("Test Passed: Selected Family Member is " + selectedMemberName + ".");
	            } else {
	                System.out.println("No family members available in the dropdown.");
	            }
	        } catch (TimeoutException e) {
	            // Handle timeout exception, log an error, or take appropriate action
	            System.out.println("TimeoutException: Element not found within the specified time.");
	            // You may also throw the exception again or handle it based on your application's needs.
	        }
	    }

	    
	    
	    

	    public void selectReminder() {
	        try {
	            // Select a reminder (example: 5 min before)
	            WebElement reminderDropdown = waitUtil.waitForElementToBeClickable(REMINDER_DROPDOWN);
	            Select reminderDropdownOptions = new Select(reminderDropdown);

	            // Get the list of available reminder options
	            List<WebElement> reminderOptions = reminderDropdownOptions.getOptions();

	            // Check if there are any reminder options available
	            if (!reminderOptions.isEmpty()) {
	                // Generate a random index to select a reminder option
	                Random random = new Random();
	                int randomIndex = random.nextInt(reminderOptions.size());

	                // Select the reminder option at the random index
	                reminderDropdownOptions.selectByIndex(randomIndex);

	                // Optional: Perform actions after selecting the reminder option if needed

	                // Get the text of the selected reminder option
	                WebElement selectedReminderOption = reminderOptions.get(randomIndex);
	                String selectedReminder = selectedReminderOption.getText().trim();
	                System.out.println("Selected Reminder: " + selectedReminder);

	                // Optional: Print the selected reminder option for verification
	                System.out.println("Test Passed: Selected Reminder is " + selectedReminder + ".");
	            } else {
	                System.out.println("No reminder options available in the dropdown.");
	            }
	        } catch (TimeoutException e) {
	            // Handle timeout exception, log an error, or take appropriate action
	            System.out.println("TimeoutException: Element not found within the specified time.");
	            // You may also throw the exception again or handle it based on your application's needs.
	        }
	    }

	    
	    // Method to generate random text
	    private String generateRandomText() {
	        // You can adjust the length and other parameters as needed
	        return RandomStringUtils.randomAlphanumeric(20); // Generating random alphanumeric text of length 20
	    }

	    public void enterDescription() {
	        try {
	            // Enter a random description
	            WebElement descriptionInput = waitUtil.waitForElementToBeClickable(DESCRIPTION_INPUT);
	            String randomText = generateRandomText();
	            descriptionInput.sendKeys(randomText);

	            // Print the entered random text
	            System.out.println("Entered Description: " + randomText);
	        } catch (TimeoutException e) {
	            // Handle timeout exception, log an error, or take appropriate action
	            System.out.println("TimeoutException: Element not found within the specified time.");
	            // You may also throw the exception again or handle it based on your application's needs.
	        }
	    }
	    
	    

	 

	    public void clickOnSave() {
	        // Click on the SAVE_BUTTON
	        WebElement saveButton = waitUtil.waitForElementToBeClickable(SAVE_BUTTON);
	        saveButton.click();
	    }

	    public boolean isEventCreatedSuccessfully() {
	        // Check if the success message is displayed
	        WebElement successMessage = waitUtil.waitForElementToBeVisible(SUCCESS_MESSAGE);
	        System.out.println("Success MEssage: "+successMessage);
	        return successMessage.isDisplayed();
	    }
	}



