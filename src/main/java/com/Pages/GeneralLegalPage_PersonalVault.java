package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class GeneralLegalPage_PersonalVault {
	
	private WebDriver driver;
	private By Clickon_Generallegal =By.xpath("//p[contains(text(),'General Legal Information')]");
	private By Addfile=By.xpath("//span[contains(text(),'Add')]");
	private By uploadfile=By.xpath("//input[@id='file-upload']");
   private By verifysuccess=By.xpath("//div[contains(text(),'successfully ')]");

	public GeneralLegalPage_PersonalVault(WebDriver driver) {
		this.driver=driver;
	}
 
	public String getGenerallegalTitle() {
		return driver.getTitle();
	}

	public void clickgenerallegal() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(Clickon_Generallegal).click();
	}

	public void addfile() {
		driver.findElement(Addfile).click();
	}
 
	public void uploadfile(String filePath) throws InterruptedException {
		WebElement fileInput = driver.findElement(uploadfile);
	        String script = "arguments[0].setAttribute('style', 'display: block; visibility: visible;');";
	        ((JavascriptExecutor) driver).executeScript(script, fileInput);
			fileInput.sendKeys(filePath);
	        Thread.sleep(1000);

			}
	public void verify() {
		WebElement successMessage = driver.findElement(verifysuccess);
	    System.out.println(">> Print: "+ successMessage.isDisplayed());
	}
}