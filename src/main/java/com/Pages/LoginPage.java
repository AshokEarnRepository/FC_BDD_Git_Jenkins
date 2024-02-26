package com.Pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class LoginPage {
 
	private WebDriver driver;
 
	private By landPageLogin = By.xpath("//a[text()='Log In']");
	private By FamilyLogin = By.xpath("//button[@class='primary_btn mb-3']");
	// input[@id='login-email']
 
	private By username = By.xpath("//input[@id='login-email']");
	private By Password = By.xpath("//input[@id='login-password']");
	private By signInButton = By.xpath("(//button[text()='Login'])[1]");
//	private By forgotPwdLink = By.linkText("Forgot Password?");
 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
 
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void landPageLoginOption() {
		driver.findElement(landPageLogin).click();
	}

	public void FamilyLoginOption() {
		driver.findElement(FamilyLogin).click();
	}

 
	public void enteremailaddress(String emailaddress) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(username).sendKeys(emailaddress);
	}
 
	public void enterpassword(String password) {
		driver.findElement(Password).sendKeys(password);
 
	}
 
	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("Login with: "+un+ " and " +pwd);
		driver.findElement(landPageLogin).click();
		driver.findElement(FamilyLogin).click();
		driver.findElement(username).sendKeys(un);
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}
 
}