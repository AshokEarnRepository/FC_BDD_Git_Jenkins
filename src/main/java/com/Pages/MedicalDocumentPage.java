package com.Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Utils.ScrollUtils;

public class MedicalDocumentPage {

    private WebDriver driver;
    private WebDriverWait wait; 
    private ScrollUtils scroll;
    

    private String filename ="ashokp";
    // Locators:
    private By familyAccessFilesLink = By.xpath("//a[@class='nav-link']//span[contains(text(),'Family Access Files')]");
    private By medicalFolderLink = By.xpath("(//div[@class='box_icon']/following::p)[1]");
    private By subscriberLink = By.xpath("(//div[@class='box_icon']/following-sibling::p)[1]");
    private By vaccineCardsFolderLink = By.xpath("(//div[@class='box_icon_name']/child::p)[1]");
    private By addButton = By.xpath("//button[normalize-space()='Add']");
    private By newDocumentLink = By.xpath("(//a[@class='dropdown-item d-flex align-items-center gap-2'])[1]");
    private By documentNameInput = By.xpath("//input[@placeholder='Enter a document name']");
    private By nextButton = By.xpath("//button[normalize-space()='Next']");//button[text()='Next']
    private By enterTextField = By.xpath("//div[@class='angular-editor-textarea']");
    private By saveButton = By.xpath("//button[text()='Save']");
    private By successMessage = By.xpath("//div[contains(text(),'added successfully')]");
    private By uploadedText = By.xpath("//p[contains(text(),'Uploaded: Feb 22, 2024')]");
    private By closeButton = By.xpath("//button[normalize-space()='Close']");
    
    
    
    private By addButtonLocator = By.xpath("//button[contains(text(),'Add')]");
    private By takePictureOptionLocator = By.xpath("//span[contains(text(),'Take a picture')]");
    private By takePictureOptionLocator2 = By.xpath("(//span[contains(text(),'Take a picture')])[2]");
    
    private By filenameInputLocator = By.xpath("//input[@name='filename']");
    private By saveButtonLocator = By.xpath("//button[text()='Save']");
    private By uploadedSuccessfullyLocator = By.xpath("//div[@aria-label='Uploaded successfully']");


    // Constructor of the page class:
    public MedicalDocumentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.scroll = new ScrollUtils(driver);
    }

    // Page Actions: Features(behavior) of the page in the form of methods:

    public void clickOnFamilyAccessFiles() {
        WebElement familyAccessFiles = wait.until(ExpectedConditions.elementToBeClickable(familyAccessFilesLink));
        familyAccessFiles.click();
    }

    public void clickOnMedicalFolder() {
        WebElement medicalFolder = wait.until(ExpectedConditions.elementToBeClickable(medicalFolderLink));
        medicalFolder.click();
    }

    public void clickOnSubscriber() {
        WebElement subscriber = wait.until(ExpectedConditions.elementToBeClickable(subscriberLink));
        subscriber.click();
    }

    public void clickOnVaccineCardsFolder() {
        WebElement vaccineCardsFolder = wait.until(ExpectedConditions.elementToBeClickable(vaccineCardsFolderLink));
        vaccineCardsFolder.click();
    }

    public void clickOnAddButton() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addBtn.click();
    }

    public void clickOnNewDocument() {
        WebElement newDocument = wait.until(ExpectedConditions.elementToBeClickable(newDocumentLink));
        newDocument.click();

    }

    public void enterDocumentName(String documentName) {
        WebElement documentNameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(documentNameInput));
        documentNameInputField.sendKeys(documentName);
    }

    public void clickOnNextButton() {
        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextBtn.click();
    }

    public void enterTextInField() {
        WebElement textField = wait.until(ExpectedConditions.elementToBeClickable(enterTextField));
        textField.sendKeys("RandomName into the doc something");
    }

    public void clickOnSaveButton() {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveBtn.click();
    }

    public String getSuccessMessage() throws InterruptedException {
    	Thread.sleep(4000);
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return successMsg.getText();
    }

//    public void clickOnCloseButton() {
//        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeButton));
//        closeBtn.click();
//    } 
    
    
    



public void clickOnTakePictureOption() {
    WebElement takePictureOption = wait.until(ExpectedConditions.elementToBeClickable(takePictureOptionLocator));
    scroll.scrollIntoView(takePictureOption);
    takePictureOption.click();
}

public void handleCameraAlert() {
    try {
        // Wait for the alert to be present
        Alert cameraAlert = wait.until(ExpectedConditions.alertIsPresent());

        // Accept the alert to allow camera access
        cameraAlert.accept();

        // Wait for a short time to let the camera access take effect
        Thread.sleep(4000);
    } catch (InterruptedException | TimeoutException e) {
        System.out.println("Error handling camera alert: " + e.getMessage());
    }
}


public void selectTakePictureOption2() {

    // Assuming the dropdown is part of the new document form
    WebElement takePictureOption2 = wait.until(ExpectedConditions.visibilityOfElementLocated(takePictureOptionLocator2));
    scroll.scrollIntoView(takePictureOption2);
    takePictureOption2.click();
} 

public void enterFilename() {
	
    WebElement filenameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(filenameInputLocator));
    filenameInput.sendKeys("Ashokp");
}

public void clickOnSaveButtonOfPicture() throws InterruptedException {
	
    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveButtonLocator));
    saveButton.click();
    Thread.sleep(5000);
}

public boolean isUploadedSuccessfullyVisible() {
    try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedSuccessfullyLocator));
        return true;
    } catch (TimeoutException e) {
        return false;
    }
}
    


public void clicksonEmergencyPrep() {
	//Back and Forth
	WebElement clickprep = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Emergency Prep']")));
	clickprep.click();

}
    
}
