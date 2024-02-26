
package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomFolder {

    private WebDriver driver;
    private WebDriverWait wait;

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

    // Constructor of the page class:
    public AddCustomFolder(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Page Actions: Features(behavior) of the page in the form of methods:

    public void clickOnFamilyAccessFiles() {
    	
        WebElement familyAccessFiles = wait.until(ExpectedConditions.elementToBeClickable(familyAccessFilesLink));
        familyAccessFiles.click();
    }
    
    public void clickOnMedical() {
        WebElement medicalfolderr = wait.until(ExpectedConditions.elementToBeClickable(medicalFolder));
        medicalfolderr.click();
    }
    

    public void clickOnAddFolder() {
        WebElement addFolder = wait.until(ExpectedConditions.elementToBeClickable(addFolderLink));
        addFolder.click();
    }

    public void enterFolderName(String folderName) {
        WebElement folderNameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(folderNameInput));
        folderNameInputField.sendKeys(folderName);
    }

    public void clickOnAddButton() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addBtn.click();
    }

    public String getSuccessPopupMessage() {
        WebElement successPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(successPopupMessage));
        return successPopup.getText().trim();
    }

    public void clickOnCloseUserGuide() {
        WebElement closeUserGuide = wait.until(ExpectedConditions.elementToBeClickable(closeUserGuideButton));
        closeUserGuide.click();
    }

//    public String getAddedCustomFolderText() {
//        WebElement addedFolder = wait.until(ExpectedConditions.visibilityOfElementLocated(addedCustomFolder));
//        return addedFolder.getText().trim();
//    }

//    public void clickAndOpenFolder() {
//        WebElement openFolder = wait.until(ExpectedConditions.elementToBeClickable(openFolderLink));
//        openFolder.click();
//    }
}
