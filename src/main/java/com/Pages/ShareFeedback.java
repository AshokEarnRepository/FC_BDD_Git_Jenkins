package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Utils.PersonNameGenerator;
import com.qa.Utils.ScrollUtils;
import com.qa.Utils.WebDriverWaits;

public class ShareFeedback {

	WebDriver driver;
	WebDriverWaits wait;
	ScrollUtils scroll;


	private By ShareFeedBack_Section = By.xpath("//a[@class='nav-link']/child::span[text()='Share Feedback']");
	//	private By ShareFeedBack_Section = By.xpath("");
	private By TellUsText = By.xpath("//h2[text()='Tell us how we can improve Family Central for you and your family.']");
	private By emailCheck = By.id("email");
	private By PhoneCheck = By.id("phoneNumber");

	private By AccountMenu = By.xpath("//span[text()='Account Menu']");
	private By MyAccount = By.xpath("//span[text()='My Account']");
	private By existed_Email = By.xpath("//div[@class='form-group']/child::label[@for='email'][2]");
	private By existed_PhoneNumber = By.xpath("//div[@class='form-group']/child::label[@for='phone'][2]");


	private By DescriptionInput = By.xpath("//label[@id='description']/following-sibling::textarea");
	private By SendButton = By.xpath("//button[@type='submit']");


	private By SendSuccess_Msg = By.xpath("//div[contains(text(),' Send Successfully ')]");
	private By PopUp_ThankuForSubmit = By.xpath("//h3[contains(text(),'Thank you for submitting ways for Family Central to improve.')]");
	
	private By PopUp_CloseBtn = By.xpath("//button[@class='btn-close']");


	public ShareFeedback(WebDriver driver) {

		this.driver=driver;
		this.wait = new WebDriverWaits(driver, Duration.ofSeconds(30));
		this.scroll = new ScrollUtils(driver);
	}

	//	-------------------------

	public void clickOn_ShareFeedBack() {
		
		WebElement ele = wait.waitForElementToBeClickable(ShareFeedBack_Section);
		scroll.scrollIntoView(ele);
		ele.click();
	}

	public boolean verify_TellUsText() {

		WebElement textLabel = wait.waitForElementToBeVisible(TellUsText);
		return textLabel.isDisplayed();
	}

	public void verify_Email() {

		String emailText_shareFeedBack = wait.waitForElementToBeVisible(emailCheck).getText();

		wait.waitForElementToBeClickable(AccountMenu).click();
		wait.waitForElementToBeClickable(MyAccount).click();


		String Exist_emailText = wait.waitForElementToBeVisible(existed_Email).getText();
		
		WebElement ele = wait.waitForElementToBeClickable(ShareFeedBack_Section);
		scroll.scrollIntoView(ele);
		ele.click();


		if(emailText_shareFeedBack.equalsIgnoreCase(Exist_emailText)) 

			System.out.println(">> Email And Phone is present in the Share FeedBack Section correctly");

		else 
			System.out.println(">> The email And Phone number presented are not matching with the My Account Details");

	}

	public void verify_PhoneNumber() {

		String PhoneText_shareFeedBack = wait.waitForElementToBeVisible(PhoneCheck).getText();

		wait.waitForElementToBeClickable(AccountMenu).click();
		wait.waitForElementToBeClickable(MyAccount).click();

		String Exist_PhoneText = wait.waitForElementToBeVisible(existed_PhoneNumber).getText();

		WebElement ele = wait.waitForElementToBeClickable(ShareFeedBack_Section);
		scroll.scrollIntoView(ele);
		ele.click();


		if(PhoneText_shareFeedBack.equals(Exist_PhoneText)) 

			System.out.println(">> Email And Phone is present in the Share FeedBack Section correctly");

		else 
			System.out.println(">> The email And Phone number presented are not matching with the My Account Details");

	}

//	public void enter_Description() {
//
//		wait.waitForVisibilityOfElement(DescriptionInput).isEnabled();
//		System.out.println(wait.waitForPresenceOfElement(DescriptionInput).isDisplayed()); 
//		WebElement ele = wait.waitForElementToBeClickable(DescriptionInput);
//		
//		ele.click();
//		ele.sendKeys(PersonNameGenerator.generateRandomPersonName());
//	}
	
	public void enterDescription() {
	    try {
	        WebElement descriptionTextarea = wait.waitForElementToBeClickable(DescriptionInput);
	        // Scroll the element into view if needed
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", descriptionTextarea);
	        // Clear the text field before entering new text
	        descriptionTextarea.clear();
	        descriptionTextarea.sendKeys(PersonNameGenerator.generateRandomPersonName());
	        System.out.println(">> Description entered successfully.");
	    } catch (TimeoutException e) {
	        System.out.println(">> Timeout waiting for the description textarea to be clickable.");
	    } catch (ElementNotInteractableException e) {
	        System.out.println(">> The description textarea is not interactable: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println(">> An error occurred while entering description: " + e.getMessage());
	    }
	}

	

	public void clickOn_SendButton() {
//	    try {
//	        WebElement sendButton = wait.waitForElementToBeClickable(SendButton);
//	        scroll.scrollToBottom();
//	        scroll.scrollToElement(sendButton);
//	        wait.waitForElementToBeVisible(SendButton);
//	        
//	        System.out.println(">> Send Button :" + sendButton.isEnabled());
//	        sendButton.click();
//	        System.out.println(">> Clicked on Send button successfully.");
//	    } catch (ElementClickInterceptedException e) {
//	        System.out.println(">> Element click intercepted: " + e.getMessage());
//	        // Handle the interception here, such as scrolling to the element again or waiting for some time
//	    } catch (Exception e) {
//	        System.out.println(">> An error occurred while clicking on Send button: " + e.getMessage());
//	    }
		
		driver.findElement(SendButton).click();
	}


	public void verify_SuccesMessage_And_PopUpMsg() {
		
		String SuccesMessage = wait.waitForElementToBeClickable(SendSuccess_Msg).getText();
		System.out.println(">> Success Message Presented :"+SuccesMessage);

		String PopUpText = wait.waitForElementToBeClickable(PopUp_ThankuForSubmit).getText();
		System.out.println(">> PopUp Window Opend and Here is the Message :"+PopUpText);
		wait.waitForElementToBeClickable(PopUp_CloseBtn);
		
	}


}

