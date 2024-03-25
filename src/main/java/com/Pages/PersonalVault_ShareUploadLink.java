package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.Utils.OtpExtractor;
import com.qa.Utils.WebDriverWaits;

import java.time.Duration;
import java.util.ArrayList;

public class PersonalVault_ShareUploadLink {

    private WebDriver driver;
    private WebDriverWaits wait;
    

    // Personal Vault Navigation:
    private By clickOnPersonalVault = By.xpath("//a[@class='nav-link']/child::span[text()='Personal Vault']");

    // File Sharing Elements:
    private By ShareUploadOption = By.xpath("/html/body/app-root/div/app-user/div/div[2]/div[3]/app-files/div[2]/div[1]/app-folder-list/div[2]/div[1]/div/button/span/img");
    private By shareForm = By.xpath("//button[text()='Share']");
    // User Information:
    private By firstname = By.xpath("//input[@placeholder='First Name']");
    private By lastname = By.xpath("//input[@placeholder='Last Name']");
    private By email = By.xpath("//input[@type='email']");
    private By flag = By.xpath("/html/body/ngb-modal-window/div/div/app-share-upload-link/div/div/div/form/div[3]/app-phone-input/form/ngx-intl-tel-input/div/div/div/div[1]");
    private By searchcountry = By.xpath("//div//input[@placeholder='Search Country']");
    private By us = By.xpath("//div//span[text()='United States']");
    private By phone = By.xpath("//*[@id=\"phone\"]");
    private By validuntil = By.xpath("  //*[@id=\"dp\"]");
    private By validTill = By.xpath("/html/body/ngb-modal-window/div/div/app-share-upload-link/div/div/div/form/div[4]/select/option[4]");
//Email Interaction:
    private By enteremail = By.xpath("//input[@id='login']");
    private By clickArrow = By.xpath("//*[@id=\"refreshbut\"]/button/i");
    private By emaillink = By.xpath("//span[text()='Family Central']/following::div[contains(text(),'You an Invitation to Family Central')]");
  //Email Verification and Authentication:
    private By frame = By.xpath("//*[@id='ifmail']");
    private By signin = By.xpath("//*[@id='mail']/div/center/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[6]/td/table/tbody/tr/td/div/a/span");
    private By otp = By.xpath("/html/body/main/div/div/div/center/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[6]/td");
    private By entercode = By.xpath("  //input[@class='otp-input ng-pristine ng-valid ng-star-inserted ng-touched']");
    private By submit = By.xpath("//button[@type='submit']");
//File Upload:
    private By file = By.xpath("//span[text()='Select a file to upload']");
    private By send = By.xpath("//button[text()=' Send ']");
    private By otpfield = By.xpath("(//input[@autocomplete='one-time-code'])[1]");
    
    
    private By OTPElementPresent = By.xpath("//tbody/tr[1]/td[3]");



    public PersonalVault_ShareUploadLink(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWaits(driver, Duration.ofSeconds(20));
    }

    // ... existing methods ...
	public String getPersonalvaultTitle() {
		
		return driver.getTitle();
		
	}

	public void clickonPersonalvault() {
		
		WebElement personalVaultElemt= wait.waitForElementToBeClickable(clickOnPersonalVault);
		personalVaultElemt.click();
		
		System.out.println("user clicked on PersonalVault: "+personalVaultElemt);
	}

	//Otp extract from here
	  
	
		 // Method to extract OTP
		    public String extractOtpFromSmstome() throws InterruptedException {
		    	 // Call the method to extract OTP
		        String extractedOtp = OtpExtractor.extractOtpFromSmstome(driver, wait);
		        
		        // Use the extracted OTP as needed
		        System.out.println("Extracted OTP: " + extractedOtp);
				return extractedOtp;
		}

    public void sharefile() {
        wait.waitForVisibilityOfElement(ShareUploadOption).click();
    }

    public void firstname() {
        wait.waitForVisibilityOfElement(firstname).sendKeys("Ramya");
    }

    public void lastname() {
        wait.waitForVisibilityOfElement(lastname).sendKeys("test");
    }

    public void email() {
        wait.waitForVisibilityOfElement(email).sendKeys("nramya24@yopmail.com");
    }

    public void flag() {
        wait.waitForVisibilityOfElement(flag).click();
    }

    public void searchcountry() {
        wait.waitForVisibilityOfElement(searchcountry).sendKeys("United States");
    }

    public void us() {
        wait.waitForVisibilityOfElement(us).click();
    }

    public void phone() {
        wait.waitForVisibilityOfElement(phone).sendKeys("+12292127375");
    }

    public void validuntil() {
        wait.waitForVisibilityOfElement(validuntil).click();
    }

    public void validTill() {
        wait.waitForVisibilityOfElement(validTill).click();
    }

    public void share() {
        wait.waitForVisibilityOfElement(shareForm).click();
    }

    public void yopmail() {
        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
        driver.get("https://yopmail.com/en/");
        driver.navigate().refresh();
    }

    public void enteremail() {
        wait.waitForVisibilityOfElement(enteremail).sendKeys("nramya24@yopmail.com");
    }

    public void click() {
        wait.waitForVisibilityOfElement(clickArrow).click();
    }

    public void frame() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.waitForVisibilityOfElement(frame).click();
    }

    public void emaillink() {
        driver.navigate().refresh();
        wait.waitForVisibilityOfElement(emaillink).click();
    }

    public void signin() throws Throwable {
        driver.switchTo().frame(2);
        wait.waitForVisibilityOfElement(signin).click();
        Thread.sleep(5000);
    }

    public void code() throws Throwable {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(5000);
        driver.navigate().refresh();
        driver.switchTo().frame(2);
        String otpText = wait.waitForVisibilityOfElement(otp).getText();
        String OtpValue = otpText.concat(otpText);
        driver.switchTo().window(tabs.get(2));
        wait.waitForVisibilityOfElement(entercode).sendKeys(OtpValue);
        wait.waitForVisibilityOfElement(submit).click();
    }
}
