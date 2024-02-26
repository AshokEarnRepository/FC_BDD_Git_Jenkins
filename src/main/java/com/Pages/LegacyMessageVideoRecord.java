package com.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class LegacyMessageVideoRecord {

	private WebDriver driver;
	WebDriverWait wait;
	
	private static String year = "2024"; 
	private String month = "March";
	private String Day   = "04";
 

	private final Faker faker = new Faker();
	
	private String lastGeneratedRandomTitle; // Variable to store the last generated random title
	
//	String randomTitle;
//	String randomDate;

	    // Locators
	private By otpElement  = By.xpath("//tbody/tr[1]/td[3]");
	private By otpfield = By.xpath("(//input[@autocomplete='one-time-code'])[1]");
	
	    private By legacyMessagesButton = By.xpath("//span[normalize-space()='Legacy Messages']");
	    private By otpInputs = By.xpath("//input[contains(@id,'otp_')]");
	    private By createFirstMessageButton = By.xpath("//button[normalize-space()='Create your first message']");
	    private By NewMessageBtn = By.xpath("//button[contains(text(),'New Message')]");
	    private By recordOneHereButton = By.xpath("//button[text()='record one here.']");
	    private By recordVideoMessageButton = By.xpath("//p[normalize-space()='Record video message']");
	    private By recordNowButton = By.xpath("//button[normalize-space()='Record now']");
	    private By startRecordingButton = By.xpath("//button[normalize-space()='Start Recording']");
	    private By stopRecordingButton = By.xpath("//button[normalize-space()='Stop Recording']");
	    private By nextButton = By.xpath("//button[normalize-space()='Next']");
	    private By messageTitleInput = By.xpath("//input[@id='msg_title']");
	    private By NextBtn_MessageTitle = By.xpath("//button[@class='primary_btn']");
	    private By myFamilyButton = By.xpath("//p[normalize-space()='My Family']");
	    private By SelectAllButton = By.xpath("//input[@id='select_all']");
	    private By NextBtn_afterSelectAll = By.xpath("//button[normalize-space()='Next']");
	    private By specificDateLabel = By.xpath("//label[normalize-space()='Specific date']");
	    private By specificYearDropdown = By.xpath("//select[@id='specific-year']");
	    private By specificMonthDropdown = By.xpath("//select[@id='specific-month']");
	    private By specificDayDropdown = By.xpath("//select[@id='specific-days']");
	    private By nextButtonAfterSpecificDate = By.xpath("//button[normalize-space()='Next']");
	    private By userUpdatedToast = By.xpath("//div[contains(text(),'Updated successfully')]");
	    private By UploadedVideoTableData = By.xpath("//tbody/tr/td");
	    private By closeButton = By.xpath("//button[normalize-space()='Close']");

	
	
	public LegacyMessageVideoRecord(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		}
 
		public String getLegacyMessageTitle() {
			return driver.getTitle();
		}
		
	    // Methods to interact with elements
	    public void clickLegacyMessages() {
	        WebElement legacyMessagesModule = wait.until(ExpectedConditions.presenceOfElementLocated(legacyMessagesButton));
	        legacyMessagesModule.click();
	    }
	    
	  //Otp extract from here
		  
			
	 // Method to extract OTP
	    public String extractOtpFromSmstome() throws InterruptedException {
	        // Open a new tab
	        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");
	        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	        driver.switchTo().window(tabs.get(1));

	        // Navigate to the OTP extraction page
	        driver.get("https://smstome.com/usa/phone/12392990815/sms/5626");

	        // Refresh the page to trigger OTP generation
	        driver.navigate().refresh();

	        Thread.sleep(3000);
	        driver.navigate().refresh();
	        // Wait for the OTP element to be present
	        WebElement otpElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[1]/td[3]")));

	        // Scroll the OTP element into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", otpElement);

	        // Wait for the OTP text to be visible
	        wait.until(ExpectedConditions.visibilityOf(otpElement));

	        // Extract OTP value
	        String otpText = otpElement.getText();
	        int startIndex = otpText.indexOf("is ") + "is ".length();
	        int endIndex = otpText.indexOf(". It will be valid");
	        String otpValue = otpText.substring(startIndex, endIndex);

	        // Switch back to the original tab
	        driver.switchTo().window(tabs.get(0));

	        // Wait for the OTP field to be clickable
	        WebElement otpField = wait.until(ExpectedConditions.elementToBeClickable(otpfield));

	        // Send OTP value to the corresponding field
	        otpField.sendKeys(otpValue);

	        return otpValue;
	    }

//Otp extract end


	    public void clickCreateFirstMessage() {
	        // Wait for the element to be clickable
	        WebElement createFirstMsg = wait.until(ExpectedConditions.elementToBeClickable(createFirstMessageButton));

	        // Check if "Create" option is available
	        if (driver.findElements(NewMessageBtn).isEmpty()) {
	            // If "Create" option is not available, click on "New Message" option
	            WebElement newMessageBtn = wait.until(ExpectedConditions.elementToBeClickable(NewMessageBtn));
	            newMessageBtn.click();
	        } else {
	            // If "Create" option is available, scroll the element into view
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", createFirstMsg);

	            // Click the "Create" option after it's in view
	            createFirstMsg.click();
	        }
	    }



	    public void clickRecordOneHere() {
	    	WebElement recordOneHere=  wait.until(ExpectedConditions.elementToBeClickable(recordOneHereButton));
	    	recordOneHere.click();
	    }

	    public void clickRecordVideoMessage() {
	    	WebElement recordVideoMessageBtn = wait.until(ExpectedConditions.elementToBeClickable(recordVideoMessageButton));
	    	recordVideoMessageBtn.click();
	    }

	    public void clickRecordNow() {
	    	WebElement recordNowBtn = wait.until(ExpectedConditions.elementToBeClickable(recordNowButton));
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", recordNowBtn);
	    	recordNowBtn.click();
	        
	    }

		    public void clickStartRecording() throws InterruptedException {
		    	
		        WebElement startRecordingBtn = wait.until(ExpectedConditions.elementToBeClickable(startRecordingButton));
		        startRecordingBtn.click();
		        Thread.sleep(15000);
		    }

		    public void clickStopRecording() {
		    	WebElement stopRecordingBtn = wait.until(ExpectedConditions.elementToBeClickable(stopRecordingButton));
		    	stopRecordingBtn.click();
		    }

		    public void clickNext() throws InterruptedException {
		    	Thread.sleep(3000);
		        WebElement nextBtnoption = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		        
		        nextBtnoption.click();
		    }
		    
		    
		    
		    
		    
		    
		    
 //Entering Random Title	    

		    

		    // Other existing methods...

		    // Method to enter a random message title
		    public void enterRandomMessageTitle() throws InterruptedException {
		        // Use Faker library to generate a random title
		        lastGeneratedRandomTitle = faker.lorem().sentence();
		        
		        // Implement logic to enter the lastGeneratedRandomTitle value into your message title field
		        Thread.sleep(2000);
		        driver.findElement(messageTitleInput).sendKeys(lastGeneratedRandomTitle);
		    }
		    
//Entering Random Title		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		     
		    public void nextButtonMessageTitle() {
		        WebElement NextBtn_MsgTitle = wait.until(ExpectedConditions.elementToBeClickable(NextBtn_MessageTitle));
		        NextBtn_MsgTitle.click();
		    }

		    public void clickMyFamily() {
		        WebElement myFamilyBtn = wait.until(ExpectedConditions.elementToBeClickable(myFamilyButton));
		        myFamilyBtn.click();
		    }

		    public void SelectAll_CheckBox() {
		    	
		        WebElement myFamilyBtn = wait.until(ExpectedConditions.elementToBeClickable(SelectAllButton));
		        myFamilyBtn.click();
		    }
		    
		    public void clickNextAfterSelectAll() {
		        WebElement nextButtonAfterSelectAll = wait.until(ExpectedConditions.elementToBeClickable(NextBtn_afterSelectAll));
		        nextButtonAfterSelectAll.click();
		    }
		    
		    public void clickSpecificDateLabel() {
		        // Wait for the element to be clickable
		        WebElement specificDateLabelElement = wait.until(ExpectedConditions.elementToBeClickable(specificDateLabel));

		        // Scroll the element into view
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", specificDateLabelElement);

		        // Click the element after it's in view
		        specificDateLabelElement.click();
		    }


		    
		    
		    
		    
		    
		    
		    
		    
		    

//Random date selection code
		   
		        // Method to select a random year from the dropdown
		        public void selectRandomYear() {
		            WebElement yearDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(specificYearDropdown));
		            Select yearSelect = new Select(yearDropdown);

		            // Generate a random year between 2020 and 2030 (adjust the range as needed)
		            String randomYear = Integer.toString(faker.number().numberBetween(2024, 2030));

		            yearSelect.selectByValue(randomYear);
		            System.out.println(randomYear);
		        }
		        

              // Method to select a random month from the dropdown
		        public void selectRandomMonth() {
		            WebElement monthDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(specificMonthDropdown));
		            Select monthSelect = new Select(monthDropdown);

		            // Get all available options from the dropdown
		            List<WebElement> monthOptions = monthSelect.getOptions();
		            System.out.println("Print months :"+monthOptions);

		            // Generate a random index to select a month
		            int randomIndex = faker.number().numberBetween(0, monthOptions.size());

		            // Select the month at the random index
		            monthSelect.selectByIndex(randomIndex);

		            // Get the selected month text for logging
		            String selectedMonth = monthOptions.get(randomIndex).getText();
		            System.out.println(selectedMonth);
		        }
		        
		        
		        

		     // Method to select a random day from the dropdown without using Faker
		        public void selectRandomDay() {
		            WebElement dayDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(specificDayDropdown));
		            Select daySelect = new Select(dayDropdown);

		            // Get the total number of options in the dropdown
		            int totalOptions = daySelect.getOptions().size();

		            // Generate a random number between 1 and totalOptions (inclusive)
		            int randomDay = (int) (Math.random() * totalOptions) + 1;

		            // Select the option with the randomly generated day value
		            daySelect.selectByValue(Integer.toString(randomDay));

		            // Get the selected day value for printing
		            String selectedDay = daySelect.getFirstSelectedOption().getText();

		            System.out.println("Selected day: " + selectedDay);
		        }


		            
		        

//Random date selection code
		    
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		    
		 // Method to verify if the message is displayed
		    public boolean isUpdateSuccessMessageDisplayed() {
		        // Wait for the success message to be present on the page
		        wait.until(ExpectedConditions.presenceOfElementLocated(userUpdatedToast));

		        // Find the success message element
		        WebElement successMessageElement = driver.findElement(userUpdatedToast);

		        // Check if the element is displayed
		        return successMessageElement.isDisplayed();
		    }
		    
//Logic Method to Iterate cells

		    
		 /*   // Method to select a random date
		    public void selectRandomDate() {
		        // Implement logic to select a random date using your date picker or calendar
		        // For example, you can use JavaScriptExecutor to set the date value
		        String randomDate = faker.date().future(10, java.util.concurrent.TimeUnit.DAYS).toString();
		        // Set the randomDate value to your date picker element
		    } */

		  

		    // Method to click the selected video based on title
		    public void clickSelectedVideo() throws InterruptedException {
		        // Assuming UploadedVideoTableData is the locator for the table containing video information
		        List<WebElement> cells = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(UploadedVideoTableData));

		        // Iterate through the cells to find the matching video
		        for (WebElement cell : cells) {
		            // Extract the cell value (title)
		            String cellValue = cell.getText().trim();
		            
		            System.out.println("CellValue: "+ cellValue + "lastGeneratedRandomTitle: "+lastGeneratedRandomTitle);

		            // Check if the current cell contains the last generated random title
		            if (containsIgnoreCase(cellValue, lastGeneratedRandomTitle)) {
		                // Click on the corresponding vide
		                cell.click();
		                Thread.sleep(10000);
		           
		                break; // Break the loop once the video is found
		            }
		        }
		    }

		    // Helper method to check if a string contains another string (case-insensitive)
		    private boolean containsIgnoreCase(String source, String target) {
		        return source.toLowerCase().contains(target.toLowerCase());
		    }
//Logic Method to Iterate cells

		    
		    
		    public void clickClose() {
		        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		        closeBtn.click();
		    }

		    // You can continue adding methods for other interactions based on your steps...
		}


