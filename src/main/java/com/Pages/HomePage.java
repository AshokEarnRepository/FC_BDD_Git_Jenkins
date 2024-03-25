package com.Pages;

import java.time.Duration;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utils.EmailGenerator;
import com.qa.Utils.PersonNameGenerator;
import com.qa.Utils.ScrollUtils;
import com.qa.Utils.WebDriverWaits;

public class HomePage {
	
	WebDriver driver;
	private WebDriverWaits wait;
	private ScrollUtils scroll;

	// By locators for Let's get started Section
	private By viewAllButton = By.xpath("//button[@class='text_red info_btn']");
	private By homePage = By.xpath("(//span[text()='Home'])[1]");
	private By homePageText = By.xpath("(//span[text()='Home'])[2]");
	// By locator for Your Family Tab
	private By yourFamilyTab1 = By.xpath("//a[@class='nav-link active']");
	private By AllYourfamilyList  = By.xpath("//h4[@class='h5']");
//	private By  = By.xpath("");
//	private By  = By.xpath("");
	

	// By locators for My Family Module
	private By addMemberButton = By.xpath("//button[contains(text(),'AddMember')]");
	private By popUpWindow = By.xpath("//div[@class='popup-window']");
	private By invitePersonNameInput = By.xpath("//input[@id='invitePersonName']");
	private By inviteEmailInput = By.xpath("//input[@id='inviteEmail']");
	private By sendInviteButton = By.xpath("//button[@id='sendInvite']");
	private By inviteSentMessage = By.xpath("//div[contains(text(),'Invite has been sent to email')]");

	// By locators for "Are you ready to start your day?" text
	private By inviteYourAdvisorsLink = By.xpath("//span[text()='Invite Your Advisors']");
	private By inviteOption = By.xpath("//span[text()='Invite']");
	private By homePageLink2 = By.xpath("(//span[text()='Home'])[1]");
	private By trustedProfessionalAdvisorTab = By.xpath("//span[text()='Trusted Professional Advisor']");
	private By tpaNamesList = By.xpath("//h5[@class='h5 ng-star-inserted']");

	
	private By areYouReady = By.xpath("//p[text()='Are you ready to start your day?']");
	private By MYFAMILY = By.xpath("(//span[normalize-space()='My Family'])[1]");
	
	private By AddaFamilyMember = By.xpath("//a[@class='collapsed btn' and text()=' Add a family member ']");
	private By ClickAdd = By.xpath("(//button[@class='primary_btn'])[1]");
	private By EnterNamePopUp = By.xpath("//input[@id='name']");
	private By EnterEmailPopUp = By.xpath("//input[@id='inviteEmail']");
	private By ClickSendInvitePopUp = By.xpath("(//button[@class='primary_btn'])[4]");
	
	
	private By uploadPic = By.xpath("(//a[@class='collapsed btn'])[2]");
	private By UploadBtn = By.xpath("(//button[@class='primary_btn'])[2]");
	private By UploadPopUp = By.xpath("//strong[@class='secondary_blue']");
	private By verifyUploadSuccessText = By.xpath("//strong[contains(text(),'Uploaded Successfully')]");
	private By clickSaveBtn = By.xpath("(//button[@class='primary_btn'])[4]");
	

	public HomePage(WebDriver driver) {
		// Constructor to initialize the WebDriver
		this.driver = driver;
		this.wait = new WebDriverWaits(driver, Duration.ofSeconds(20));
		this.scroll = new ScrollUtils(driver);
	}

	// Methods to perform actions on Let's get started Section
	public void VerifyGetStartedText() {
	    WebElement GetStartedText = wait.waitForElementToBeVisible(By.xpath("//h2[@class='h2 mb-0']"));

	    String DashBoadText = GetStartedText.getText();

	    if (DashBoadText.contains("Let’s get started")) {
	        System.out.println("Lets get started is displayed");

	        wait.waitForElementToBeClickable(AddaFamilyMember).isEnabled();
	        wait.waitForElementToBeClickable(AddaFamilyMember).click();

	        // Verify and perform actions for adding a family member
	        verifyAndAddFamilyMember();

	    } else if (DashBoadText.contains("Let’s get started")) {
	    	
//	        System.out.println("Upload Profile Picture option is displayed");
	    	 wait.waitForElementToBeClickable(uploadPic).isEnabled();

	        // Verify and perform actions for uploading profile picture
	        verifyAndUploadProfilePicture();

	    } else {
	        System.out.println("Are you ready to start your day? is displayed");

	        // Perform actions specific to this scenario
	        String areyouReadyText = wait.waitForElementToBeClickable(areYouReady).getText();
	        System.out.println(areyouReadyText);

	        wait.waitForElementToBeClickable(MYFAMILY).click();
	    }
	}

	// Method to verify and add a family member
	private void verifyAndAddFamilyMember() {
	    wait.waitForElementToBeClickable(ClickAdd).click();
	    wait.waitForElementToBeClickable(EnterNamePopUp).sendKeys(PersonNameGenerator.generateRandomPersonName());
	    wait.waitForElementToBeClickable(EnterEmailPopUp).sendKeys(EmailGenerator.generateRandomEmail());
	    wait.waitForElementToBeClickable(ClickSendInvitePopUp).click();
	}

	// Method to verify and upload profile picture
	private void verifyAndUploadProfilePicture() {
	    wait.waitForElementToBeClickable(uploadPic).click();
	    wait.waitForElementToBeClickable(UploadBtn).click();
	    wait.waitForElementToBeClickable(UploadPopUp).sendKeys("C:\\Users\\Ashok\\Downloads\\Untitled.png");
	    wait.waitForElementToBeClickable(verifyUploadSuccessText).isDisplayed();
	    wait.waitForElementToBeClickable(clickSaveBtn).click();
	}

	// Methods to perform actions on My Family Module
	public void clickOnHome() {
		wait.waitForElementToBeClickable(homePage).click();
	}
	
	// Additional Methods (Based on Feature File and Steps)

	public void clickOnAddMember() {
		wait.waitForElementToBeClickable(addMemberButton).click();
	}

	public void verifyPopUpWindow() {
		wait.waitForElementToBeVisible(popUpWindow);
	}

	public void enterInvitePersonName(String personName) {
		wait.waitForElementToBeClickable(invitePersonNameInput).sendKeys(personName);
	}

	public void enterInvitePersonEmail(String emailAdd) {
		wait.waitForElementToBeClickable(inviteEmailInput).sendKeys(emailAdd);
	}

	public void clickOnSendInvite() {
		wait.waitForElementToBeClickable(sendInviteButton).click();
	}

	public boolean verifyInviteSentMessage() {
		WebElement message = wait.waitForPresenceOfElement(inviteSentMessage);
		System.out.println(message);
		return message.isDisplayed();
	} 
	
	public void ClickYourFamilyTab() {
		WebElement yourfamilyTab = wait.waitForElementToBeClickable(yourFamilyTab1);
		yourfamilyTab.click();
		
	} 
	
	public void AllYourfamilyList(String emailAdd) {
		List<WebElement> yourfamilyList = driver.findElements(AllYourfamilyList);
		if(yourfamilyList.contains(emailAdd)) {
			System.out.println("Family member name is displayed");
			
		}
//		public void VerifytheAddedFamilyMember() {
//			
//			}
		
		
	}

	public boolean VerifyHomePage() {
		// TODO Auto-generated method stub
		WebElement homepag = wait.waitForElementToBeClickable(homePage);
		return homepag.isDisplayed();
	} 


}
