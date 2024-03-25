package com.Pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Utils.FolderNameGenerator;
import com.qa.Utils.Generate_FileUploadHelper;
import com.qa.Utils.ScrollUtils;
import com.qa.Utils.WebDriverWaits;

public class AddCustomFolder {

	private WebDriver driver;
	private WebDriverWait waits;
	private WebDriverWaits wait;
	private ScrollUtils scroll;

	private String folderName = FolderNameGenerator.two_generateRandomFolderName();

	// Locators:
	private By familyAccessFilesLink = By.xpath("//a[@class='nav-link']//span[contains(text(),'Family Access Files')]");
	private By medicalFolder = By.xpath("/p[text()='Medical']");
	private By addFolderLink = By.xpath("//span[normalize-space()='Add Folder']");
	private By folderNameInput = By.xpath("//input[@id='folder']");
	private By addButton = By.xpath("//button[normalize-space()='Add']");
	private By successPopupMessage = By.xpath("//h3[contains(text(),'added successfully')]");
	private By closeUserGuideButton = By.xpath("//button[@aria-label='close user guide']");
	//    private By addedCustomFolder = By.xpath("//p[normalize-space()='customFolderOne']");
	//    private By openFolderLink = By.xpath("//h2[normalize-space()='customFolderOne']");
	
	private By ClickDropDown_UploadFile = By.xpath("//input[@id='file-upload']");
    private By uploadedSuccessfullyToast = By.xpath("//div[@aria-label='Uploaded successfully']");

	// Constructor of the page class:
	public AddCustomFolder(WebDriver driver) {
		this.driver = driver;
		this.waits = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.wait = new WebDriverWaits(driver, Duration.ofSeconds(20));
		this.scroll = new ScrollUtils(driver);
	}

	// Page Actions: Features(behavior) of the page in the form of methods:

	public void clickOnFamilyAccessFiles() {

		WebElement familyAccessFiles = waits.until(ExpectedConditions.elementToBeClickable(familyAccessFilesLink));
		familyAccessFiles.click();

		waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Files']"))).click();

	}

	public void clickOnMedical() {
		WebElement medicalfolderr = waits.until(ExpectedConditions.elementToBeClickable(medicalFolder));
		medicalfolderr.click();
	}

	public void clickOnAddFolder() {
		WebElement addFolder = waits.until(ExpectedConditions.elementToBeClickable(addFolderLink));
		addFolder.click();
	}

	public void enterFolderName() {
		WebElement folderNameInputField = waits.until(ExpectedConditions.visibilityOfElementLocated(folderNameInput));
		folderNameInputField.sendKeys(folderName);
	}

	public void clickOnAddButton() {
		WebElement addBtn = waits.until(ExpectedConditions.elementToBeClickable(addButton));
		addBtn.click();
	}

	public String getSuccessPopupMessage() {
		WebElement successPopup = waits.until(ExpectedConditions.visibilityOfElementLocated(successPopupMessage));
		return successPopup.getText().trim();
	}

	public void clickOnCloseUserGuide() {
		WebElement closeUserGuide = waits.until(ExpectedConditions.elementToBeClickable(closeUserGuideButton));
		closeUserGuide.click();
	}

	public boolean isAddedFolderVisible() {


		WebElement addedFolder =wait.waitForVisibilityOfElement(By.xpath("//p[@class='mb-0 file_length' and text()='" + folderName + "']"));
		//        WebElement addedFolder = driver.findElement(By.xpath("//p[@class='mb-0 file_length' and text()='" + folderName + "']"));


		System.out.println(">> Added Folder Name : "+addedFolder);
		scroll.scrollToElement(addedFolder);
		return addedFolder.isDisplayed();
	}

	public void clickOnAddedFolder() throws InterruptedException {
		By folderXpath = By.xpath("//p[@class='mb-0 file_length' and text()='" + folderName + "']");
		WebElement addedFolder = wait.waitForElementToBeClickable(folderXpath);

		try {
			addedFolder.click();
		} catch (ElementClickInterceptedException e) {
			// If the element is not clickable, scroll into view and click again
			scroll.scrollIntoView(addedFolder);
			addedFolder.click();
		}

		Thread.sleep(3000);
	}
	/* public void uploadFile(String fileFormat) {
	    // Locate the file input element in the page class
	    WebElement fileInput = driver.findElement(ClickDropDown_UploadFile);
	    
	    // Upload the file using FileUploadHelper
	    Generate_FileUploadHelper.uploadFile(driver, fileInput, fileFormat);
	} */

	public void isUploadedSuccessfullyVisible() throws InterruptedException {
	    try {
	        WebElement ele = wait.waitForVisibilityOfElement(uploadedSuccessfullyToast);
	        String successToast = ele.getText();
	        System.out.println("file uploaded success message : " + successToast);
	        // If element is displayed, print success message
	        if (ele.isDisplayed()) {
	            System.out.println("IsUploadedSuccess Displayed:");
	        } else {
	            System.out.println(">> Upload success message did not appear");
	        }
	    } catch (TimeoutException e) {
	        // If element is not found within the specified time, print error message
	        System.out.println(">> Upload success message did not appear");
	    }
	}
	
	public void uploadFile(String fileFormat) throws InterruptedException {
	    // Locate the file input element in the page class
	    WebElement fileInput = driver.findElement(ClickDropDown_UploadFile);
	    
	    // Upload the file using FileUploadHelper
	    Generate_FileUploadHelper.uploadFile(driver, fileInput, fileFormat);
	    
	    // Check for success message after each upload
	}
	
}
