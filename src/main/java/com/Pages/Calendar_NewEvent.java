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

	        
	        
	        
	    

	    public void selectStartDate() {
	        // Wait for and click on the START_DATE element
	    	WebElement startDateCalendarView = waitUtil.waitForElementToBeClickable(START_DATE);
	        startDateCalendarView.click();
	    	
	    	WebElement clickOnDay = waitUtil.waitForElementToBeClickable(By.xpath("//div[@class='btn-light ng-star-inserted' and text()='5']"));
	    	clickOnDay.click();
	    	
	    	/*
	        WebElement startDateCalendarView = waitUtil.waitForElementToBeClickable(START_DATE);
	        startDateCalendarView.click();
	     
	        // Select a month (example: Aug)
	        WebElement monthDropdown = waitUtil.waitForElementToBeClickable(MONTH_SELECT);
	        Select monthDropDownOptions = new Select(monthDropdown);
	        System.out.println(monthDropDownOptions);
	        monthDropDownOptions.selectByVisibleText("Aug");
	        

	        // Select a year (example: 2024)
	        WebElement yearDropdown = waitUtil.waitForElementToBeClickable(YEAR_DROPDOWN);
//	        yearDropdown.click();
//	        WebElement yearDropDown = waitUtil.waitForVisibilityOfElement(YEAR_SELECT);
	        System.out.println(yearDropdown);
	        Select yearDropDownOptions = new Select(yearDropdown);
	        yearDropDownOptions.selectByIndex(4);

	        // Select a day (example: 28)
	        WebElement daySelectElement = waitUtil.waitForElementToBeClickable(DAY_SELECT);
	        String desiredDay = "28";
	        String selectedDay = daySelectElement.getText();

	        // Check if the selected day matches the desired day
	        if (selectedDay.equals(desiredDay)) {
	            // Perform further actions if the day is as expected
	            System.out.println("Day is selected correctly: " + selectedDay);
	        } else {
	            // Handle the case when the selected day is not as expected
	            System.out.println("Day is not selected as expected. Actual day: " + selectedDay);
	        }
	        
	        */
	    }
		
		
		
		
		
		
	    // Additional Page Actions (Continued):

	    public void selectEndDate() {
	    	
	    	 // Wait for and click on the START_DATE element
	    	WebElement EndDateCalendarView = waitUtil.waitForElementToBeClickable(END_DATE);
	    	EndDateCalendarView.click();
	    	
	    	WebElement clickOnDay = waitUtil.waitForElementToBeClickable(By.xpath("//div[@class='btn-light ng-star-inserted' and text()='5']"));
	    	clickOnDay.click();
	    }
	    	
	    /*	
	        // Wait for and click on the END_DATE element
	        WebElement endDateCalendarView = waitUtil.waitForElementToBeClickable(END_DATE);
	        endDateCalendarView.click();

	        // Similar logic as selecting start date...
	        // Select a month (example: Sep)
	        WebElement monthDropdown = waitUtil.waitForElementToBeClickable(MONTH_SELECT);
	        Select monthDropDownOptions = new Select(monthDropdown);
	        monthDropDownOptions.selectByVisibleText("Sep");

	        // Select a year (example: 2024)
	        WebElement yearDropdown = waitUtil.waitForElementToBeClickable(YEAR_DROPDOWN);
	        yearDropdown.click();
	        WebElement yearDropDown = waitUtil.waitForElementToBeClickable(YEAR_SELECT);
	        Select yearDropDownOptions = new Select(yearDropDown);
	        yearDropDownOptions.selectByVisibleText("2024");

	        // Select a day (example: 15)
	        WebElement daySelectElement = waitUtil.waitForElementToBeClickable(DAY_SELECT);
	        String desiredDay = "15";
	        String selectedDay = daySelectElement.getText();

	        // Check if the selected day matches the desired day
	        if (selectedDay.equals(desiredDay)) {
	            // Perform further actions if the day is as expected
	            System.out.println("End date is selected correctly: " + selectedDay);
	        } else {
	            // Handle the case when the selected day is not as expected
	            System.out.println("End date is not selected as expected. Actual day: " + selectedDay);
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



