package com.Pages;
 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utils.WebDriverWaits;
 
public class LoginPage {
 
	private WebDriver driver;
	WebDriverWaits wait;
 
	private By landPageLogin = By.xpath("//a[text()='Log In']");
	private By FamilyLogin = By.xpath("//button[@class='primary_btn mb-3']");
	// input[@id='login-email']
 
	private By username = By.xpath("//input[@id='login-email']");
	private By Password = By.xpath("//input[@id='login-password']");
	private By signInButton = By.xpath("(//button[text()='Login'])[1]");
	
//	private By forgotPwdLink = By.linkText("Forgot Password?");
 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		 this.wait = new WebDriverWaits(driver, Duration.ofSeconds(20));
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
 
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void landPageLoginOption() {
		driver.navigate().refresh();
		wait.waitForElementToBeClickable(landPageLogin).click();
//		driver.findElement(landPageLogin)
	}

	public void FamilyLoginOption() {
		wait.waitForElementToBeClickable(FamilyLogin).click();
//		driver.findElement(FamilyLogin).click();
	}

 
	public void enteremailaddress(String emailaddress) throws InterruptedException {
//		Thread.sleep(2000);
		WebElement userName = wait.waitForElementToBeClickable(username);
		userName.isDisplayed();
		userName.isEnabled();
		userName.sendKeys(emailaddress);
		
//		driver.findElement(username).sendKeys(emailaddress);
	}
 
	public void enterpassword(String password) {
		
//		driver.findElement(Password).sendKeys(password);
		wait.waitForElementToBeClickable(Password).sendKeys(password);
 
	}
 
	public void clickOnLogin() {
		wait.waitForElementToBeClickable(signInButton).click();
//		driver.findElement(signInButton).click();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		
		System.out.println("Login with: "+un+ " and " +pwd);
		wait.waitForElementToBeClickable(landPageLogin).click();
		wait.waitForElementToBeClickable(FamilyLogin).click();
		wait.waitForElementToBeClickable(username).sendKeys(un);
		wait.waitForElementToBeClickable(Password).sendKeys(pwd);
		wait.waitForElementToBeClickable(signInButton).click();
		
//		driver.findElement(landPageLogin).click();
//		driver.findElement(FamilyLogin).click();
//		driver.findElement(username).sendKeys(un);
//		driver.findElement(Password).sendKeys(pwd);
//		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}
 
}










/* package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utils.WebDriverWaits;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWaits waitUtil;

    private By landPageLogin = By.xpath("//a[text()='Log In']");
    private By FamilyLogin = By.xpath("//button[@class='primary_btn mb-3']");
    private By username = By.xpath("//input[@id='login-email']");
    private By Password = By.xpath("//input[@id='login-password']");
    private By signInButton = By.xpath("(//button[text()='Login'])[1]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WebDriverWaits(driver, Duration.ofSeconds(20));
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public void landPageLoginOption() {
        WebElement landingLogin = waitUtil.waitForVisibilityOfElement(landPageLogin);
        landingLogin.click();
    }

    public void FamilyLoginOption() {
        waitUtil.waitForElementToBeClickable(FamilyLogin).click();
    }

    public void enteremailaddress(String emailaddress) {
        waitUtil.waitForElementToBeClickable(username).sendKeys(emailaddress);
    }

    public void enterpassword(String password) {
        waitUtil.waitForElementToBeClickable(Password).sendKeys(password);
    }

    public void clickOnLogin() {
        waitUtil.waitForElementToBeClickable(signInButton).click();
    }

    public AccountsPage doLogin(String un, String pwd) {
        System.out.println("Login with: " + un + " and " + pwd);
        landPageLoginOption();
        FamilyLoginOption();
        enteremailaddress(un);
        enterpassword(pwd);
        clickOnLogin();
        return new AccountsPage(driver);
    }
} */
