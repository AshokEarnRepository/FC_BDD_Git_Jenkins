package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utils.FolderNameGenerator;
import com.qa.Utils.ScrollUtils;
import com.qa.Utils.WebDriverWaits;

public class FileUpload_PhotosVideos {
    
    private WebDriver driver;
    private WebDriverWaits waitUtil;
    private ScrollUtils scrollUtils;
    
    
    private String folderName = FolderNameGenerator.generateRandomFolderName();

    // Photos and Videos Navigation:
    private By ClickPhotosVideos = By.xpath("//a[@class='nav-link']/child::span[text()='Photos & Videos']");
    private By ClickOnFamilyMember = By.xpath("(//div[@class='box_icon_name'])[1]");
    private By ClickAddBtn = By.xpath("//button[@class='primary_btn add_btn dropdown-toggle']");
    private By ClickDropDown_UploadFile = By.xpath("//input[@id='file-upload']");
    private By uploadedSuccessfullyToast = By.xpath("//div[@aria-label='Uploaded successfully']");
    private By UploadIcon = By.xpath("//span//strong[text()='Click to Upload']");
    
    
    
    // For Scenario 3
    private By ClickOnSubscriber = By.xpath("(//p[@class='text-capitalize'])[1]");
    private By ClickAddButton = By.xpath("//button[@class='primary_btn add_btn dropdown-toggle']");
    private By ClickOnNewFolder_DropDown = By.xpath("//a//span[text()='New folder']");
    private By enterFolderNameField = By.xpath("//input[@id='folder']");
    private By SubmitBtn_Add = By.xpath("//button[@type='submit']");
    private By PopUpSuccessWindow = By.xpath("//h3[contains(text(),'added successfully')]");
    private By PopUpCrossBar = By.xpath("//button[@class='btn-close mt-2 me-2']");
    private By AlladdedFolders = By.xpath("//div[@class='single_box ng-star-inserted dropdown']/a/div/p");
//    private By UploadIcon = By.xpath("//span//strong[text()='Click to Upload']");
    
    
    // Constructor of the page class:
    public FileUpload_PhotosVideos(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WebDriverWaits(driver, Duration.ofSeconds(20));
        this.scrollUtils = new ScrollUtils(driver);
    }
    
 // Page Actions:
       

    public void clickOnPhotosAndVideos() {
    	 // Locate the element you want to scroll into view
        WebElement yourElement = waitUtil.waitForElementToBeClickable(ClickPhotosVideos);

        // Scroll into view using the utility method
        scrollUtils.scrollToElement(yourElement);

        // Now, you can perform any action on the element
        // For example, click on the element
        yourElement.click();
    }
        
    
    
    public void clickOnFamilyMember() {
    	waitUtil.waitForElementToBeClickable(ClickOnFamilyMember).click();
        
    }
    

    public void clickOnAddButton() {
        waitUtil.waitForElementToBeClickable(ClickAddBtn).click();
    }
    
  
    public void clickOnPhotoVideosBack() {
    	
        waitUtil.waitForElementToBeClickable(By.xpath("//a[text()='Photo & Video Library']")).click();
        waitUtil.waitForElementToBeClickable(ClickOnSubscriber).click();
    }
    
    public void clickOnUploadIcon() {
    	
    	 WebElement fileInput = driver.findElement(UploadIcon);
    	    String filePath = "C:\\Users\\Ashok\\Downloads\\Untitled.png";

    	    // Use JavaScript to set the value of the file input
    	    String script = "arguments[0].style.display='block'; arguments[0].style.visibility='visible'; arguments[0].value='" + filePath + "';";
    	    ((JavascriptExecutor) driver).executeScript(script, fileInput);
    }

    public void uploadFile(String filePath) {
    		
    		 // Locate the file input element
            WebElement fileInput = driver.findElement(ClickDropDown_UploadFile);
    		
//        String filePath = "C:\\Users\\Ashok\\Downloads\\Untitled.png";
        fileInput.sendKeys(filePath);
        
    }

    public boolean isUploadedSuccessfullyVisible() {
        return waitUtil.isElementVisible(uploadedSuccessfullyToast);
        
//        Thread.sleep(5000);
    }
    
    
 // Page Actions for Scenario 3:

    public void clickOnSubscriberFolder() {
        WebElement subscriber1 = waitUtil.waitForElementToBeClickable(ClickOnSubscriber);
        
        if(subscriber1.isDisplayed()) {
        	subscriber1.click();
        }else {
        	waitUtil.waitForElementToBeClickable(By.xpath("//p[@class='text-capitalize']")).click();
        }
      
    }

//    public void clickOnNewFolder() {
//        waitUtil.waitForElementToBeClickable(ClickOnNewFolder_DropDown).click();
//    }

    public void clickOnNewFolderDropDown() {
        waitUtil.waitForElementToBeClickable(ClickOnNewFolder_DropDown).click();
    }

    public void enterFolderName() {
    	
        WebElement folderNameField = waitUtil.waitForElementToBeClickable(enterFolderNameField);
        folderNameField.clear();
        folderNameField.sendKeys(folderName);
    }

    public void clickOnSubmitButton() {
        waitUtil.waitForElementToBeClickable(SubmitBtn_Add).click();
    }

    public boolean isPopUpSuccessWindowVisible() {
        return waitUtil.isElementVisible(PopUpSuccessWindow);
    }

    public void closePopUpMessage() {
        waitUtil.waitForElementToBeClickable(PopUpCrossBar).click();
    }

    public boolean isAddedFolderVisible() {
    	
    	WebElement addedFolder =waitUtil.waitForVisibilityOfElement(By.xpath("//p[@class='mb-0 file_length' and text()='" + folderName + "']"));
//        WebElement addedFolder = driver.findElement(By.xpath("//p[@class='mb-0 file_length' and text()='" + folderName + "']"));
    	scrollUtils.scrollToElement(addedFolder);
    	return addedFolder.isDisplayed();
    }

    public void clickOnAddedFolder() {
        By folderXpath = By.xpath("//p[@class='mb-0 file_length' and text()='" + folderName + "']");
        WebElement addedFolder = waitUtil.waitForElementToBeClickable(folderXpath);

        try {
            addedFolder.click();
        } catch (ElementClickInterceptedException e) {
            // If the element is not clickable, scroll into view and click again
            scrollUtils.scrollIntoView(addedFolder);
            addedFolder.click();
        }
    }

   
    
    
    
    
    


}
