package com.qa.Utils;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OtpExtractor {
	
	WebDriverWaits wait;
	
	   // Locators
		private static By otpElement  = By.xpath("//tbody/tr[1]/td[3]");
		private static By otpfield = By.xpath("(//input[@autocomplete='one-time-code'])[1]");
		private static By otpInputs = By.xpath("(//input[contains(@id,'otp_')])[1]");
    
    public static String extractOtpFromSmstome(WebDriver driver, WebDriverWaits wait) throws InterruptedException {
        // Open a new tab
    	Thread.sleep(7000);
        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        
        // Navigate to the OTP extraction page
        driver.get("https://smstome.com/usa/phone/13153558445/sms/6255");

        // Wait for the OTP element to be present
        WebElement otpElement = wait.waitForPresenceOfElement(By.xpath("//tbody/tr[1]/td[3]"));

        // Scroll the OTP element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", otpElement);

        // Extract OTP value
        String otpText = otpElement.getText();
        int startIndex = otpText.indexOf("is ") + "is ".length();
        int endIndex = otpText.indexOf(". It will be valid");
        String otpValue = otpText.substring(startIndex, endIndex);

        // Switch back to the original tab
        driver.switchTo().window(tabs.get(0));

        // Wait for the OTP field to be clickable (Assuming otpfield is defined elsewhere)
        WebElement otpField = wait.waitForElementToBeClickable(otpfield);

        // Send OTP value to the corresponding field
        otpField.sendKeys(otpValue);

        return otpValue;
    }
   
    /* public static void extract_From_SMSToMe(WebDriver driver, WebDriverWaits wait) {
    	Thread.sleep(7000);
        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        
        // Navigate to the OTP extraction page
        driver.get("https://smstome.com/usa/phone/17193045296/sms/6184");

        // Wait for the OTP element to be present
        WebElement otpElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[1]/td[3]")));

        // Scroll the OTP element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", otpElement);

        // Wait for the OTP text to be visible
//        wait.until(ExpectedConditions.visibilityOf(otpElement));

        // Extract OTP value
        String otpText = otpElement.getText();
        System.out.println(otpText);
        int startIndex = otpText.indexOf("is ") + "is ".length();
        System.out.println(startIndex);
        int endIndex = otpText.indexOf(". It will be valid");
        System.out.println(endIndex);
        String otpValue = otpText.substring(startIndex, endIndex);
        System.out.println(otpValue);

        // Switch back to the original tab
        driver.switchTo().window(tabs.get(0));

        // Wait for the OTP field to be clickable
        WebElement otpField = wait.until(ExpectedConditions.elementToBeClickable(otpfield));

        // Send OTP value to the corresponding field
        otpField.sendKeys(otpValue);

        return otpValue;
    }"  
    } */
}
