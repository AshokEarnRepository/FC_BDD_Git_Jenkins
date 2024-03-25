package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.Utils.ScrollUtils;
import com.qa.Utils.WebDriverWaits;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class InviteYourAdvisors {

    private WebDriver driver;
    private WebDriverWaits waitUtil;
    private ScrollUtils scroll;
    
    String AcceptUrl;

    // Yopmail locators
    private By YOPMAIL_LOGIN_FIELD = By.xpath("//input[@id='login']");
    private By YOPMAIL_ARROW_ICON = By.xpath("//i[@class='material-icons-outlined f36']");
    private By YOPMAIL_REFRESH_BTN = By.xpath("//button[@id='refresh']");
    private By RECEIVED_INVITE_EMAIL = By.xpath("//span[text()='Family Central']/following::div[contains(text(),'You an Invitation to Family Central')]");
    private By IFRAME_OF_EMAIL = By.xpath("//*[@id='ifmail']");
    private By CREATE_ACCOUNT_BTN = By.xpath("//span[text()='Create your account now']");

    private By InviteAdvisorModule = By.xpath("//span[text()='Invite Your Advisors']");
    private By InviteAdvisorBtn = By.xpath("//span[text()='Invite Advisor']");
    private By NameInput = By.xpath("//input[@id='advisorName']");
    private By EmailInput = By.xpath("//input[@id='advisorEmail']");
    private By sendInvite = By.xpath("//button[@type='submit']");
    private By inviteSentToast = By.xpath("//div[@class='ng-tns-c24-0 toast-message ng-star-inserted']");
    private By pendingText = By.xpath("(//div[text()=' Pending '])[1]");

    private By yopmailSignUpNow = By.xpath("//span[text()='Sign up now']");
    private By AcceptInvite = By.xpath("//a[text()='Accept Invite']");

    private By otpElement = By.xpath("//tbody/tr[1]/td[3]");
    private By otpfield = By.xpath("(//input[@autocomplete='one-time-code'])[1]");
    
    private By nameInput = By.xpath("(//input[@name='name'])[1]");
    private By lastNameInput = By.xpath("(//input[@name='name'])[2]");
    private By emailInput = By.xpath("//input[@id='email']");
    private By flagDropDown = By.xpath("//div[@class='iti__selected-flag dropdown-toggle']");
    private By phoneNumberInput = By.xpath("//input[@id='phone']");
    private By companyInput = By.xpath("//input[@id='company']");
    private By selectDropdown = By.xpath("//select[@id='advisory']");
    private By checkbox = By.xpath("//input[@id='flexCheckDefault']");
    private By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    private By otpField = By.xpath("(//input[@autocomplete='one-time-code'])[1]");
    private By continueButton1 = By.xpath("//button[contains(text(),'Continue')]");
    private By newPasswordInput = By.xpath("//input[@id='password']");
    private By confirmPasswordInput = By.xpath("//input[@id='confirm-password']");
    private By continueButton2 = By.xpath("//button[contains(text(),'Continue')]");


    public InviteYourAdvisors(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WebDriverWaits(driver, Duration.ofSeconds(20));
        this.scroll = new ScrollUtils(driver);
    }

    public String getInviteYourAdvisorsTitle() {
        return driver.getTitle();
    }

    public void clickOnAdvisorModule() {
        WebElement advisorModuleElement = waitUtil.waitForElementToBeClickable(InviteAdvisorModule);
        advisorModuleElement.click();
        System.out.println("User clicked on Invite Your Advisors module: " + advisorModuleElement);
    }

    public void clickInviteAdvisorButton() {
        WebElement inviteAdvisorElement = waitUtil.waitForElementToBeClickable(InviteAdvisorBtn);
        inviteAdvisorElement.click();
        System.out.println("User clicked on Invite Advisor button: " + inviteAdvisorElement);
    }

    public void enterInvitePersonName(String personName) {
        WebElement nameInputElement = waitUtil.waitForElementToBeClickable(NameInput);
        nameInputElement.sendKeys(personName);
    }

    public void enterInvitePersonEmail(String emailAdd) {
        WebElement emailInputElement = driver.findElement(EmailInput);
        emailInputElement.sendKeys(emailAdd);
    }

    public void clickOnSendInvite() {
        WebElement sendInviteElement = waitUtil.waitForElementToBeClickable(sendInvite);
        sendInviteElement.click();
    }

    public boolean verifyInviteSentMessage() {
        WebElement message = waitUtil.waitForPresenceOfElement(inviteSentToast);
        System.out.println(message);
        return message.isDisplayed();
    }

    public void pendingIsDisplayed() {
        waitUtil.waitForElementToBeClickable(pendingText).isDisplayed();
        
        waitUtil.waitForElementToBeClickable(By.xpath("//span[@class='account_menu d-none d-md-inline-block']")).click();
        waitUtil.waitForElementToBeClickable(By.xpath("//span[text()='Log Out']")).click();
    }

    public void navigateToYopmail() {
        driver.get("https://yopmail.com");
    }

    public void checkReceivedInviteEmail(String emailAdd) {
        WebElement loginField = waitUtil.waitForElementToBeClickable(YOPMAIL_LOGIN_FIELD);
        loginField.sendKeys(emailAdd);
        waitUtil.waitForElementToBeClickable(YOPMAIL_ARROW_ICON).click();
    }

    public void switchToEmailIframe() {
        WebElement iframeElement = waitUtil.waitForElementToBeVisible(IFRAME_OF_EMAIL);
        driver.switchTo().frame(iframeElement);
    }

    public void clickOnSignUpNow() throws InterruptedException {
        WebElement signUP = waitUtil.waitForVisibilityOfElement(yopmailSignUpNow);
        scroll.scrollToElement(signUP);
         signUP.click();
         Thread.sleep(5000);
//         AcceptUrl  =driver.getCurrentUrl();
         
         String mainWindowHandle = driver.getWindowHandle();
         System.out.println("Main Window Handle: " + mainWindowHandle);
    }

    public void acceptInvite() throws InterruptedException {
    	  
    	 // Print a list of all open window handles
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("List of Window Handles: " + windowHandles);
        // Iterate through the handles and switch to each window
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            System.out.println("Switched to Window with Handle: " + handle);
         // Check if it's the new window (you may want to customize this condition)
            if (driver.getCurrentUrl().equals("about:blank")) {
            	
            	driver.get(AcceptUrl);
            }
        } 

    	
        WebElement Acceptinvite = waitUtil.waitForPresenceOfElement(AcceptInvite);
        Acceptinvite.click();
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", Acceptinvite);
        
    }

    public void enterAdvisorDetails() {
    	
        waitUtil.waitForElementToBeClickable(nameInput).sendKeys("Arjun");
        waitUtil.waitForElementToBeClickable(lastNameInput).sendKeys("Reddy");
        waitUtil.waitForElementToBeClickable(emailInput).sendKeys("tpasingotp13@yopmail.com");
        waitUtil.waitForElementToBeClickable(flagDropDown).click();
        waitUtil.waitForElementToBeClickable(phoneNumberInput).sendKeys("+17193045296");
        waitUtil.waitForElementToBeClickable(companyInput).sendKeys("Apollo");

        
      
        
        WebElement selectElement = waitUtil.waitForElementToBeClickable(selectDropdown);
        Select select = new Select(selectElement);
        select.selectByVisibleText("Medical");

        waitUtil.waitForElementToBeClickable(checkbox).click();
        waitUtil.waitForElementToBeClickable(continueButton).click();
    }
   
//    public void completeAdvisorInvitationFlow() throws InterruptedException {
//        enterAdvisorDetails();
////        navigateToYopmail();
////        extractOtpFromYopmail();
////        navigateBackToApplication();
//        ClickOnContinue();
//        enterNewPasswordAndContinue();
//    }

    public void enterNewPasswordAndContinue() {
        waitUtil.waitForElementToBeClickable(newPasswordInput).sendKeys("Password@123");
        waitUtil.waitForElementToBeClickable(confirmPasswordInput).sendKeys("Password@123");
        waitUtil.waitForElementToBeClickable(continueButton2).click();
    }
    
    
   

    public String extractOtpFromSmstome() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get("https://smstome.com/usa/phone/+17193045296/sms/6184");

        driver.navigate().refresh();

        Thread.sleep(3000);
        driver.navigate().refresh();

        Thread.sleep(3000);
        driver.navigate().refresh();

        WebElement  ElementOtp = waitUtil.waitForPresenceOfElement(otpElement);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", otpElement);

        String otpText = ElementOtp.getText();
        System.out.println(otpText);
        int startIndex = otpText.indexOf("is ") + "is ".length();
        System.out.println(startIndex);
        int endIndex = otpText.indexOf(". It will be valid");
        System.out.println(endIndex);
        String otpValue = otpText.substring(startIndex, endIndex);
        System.out.println(otpValue);

        driver.switchTo().window(tabs.get(0));

        WebElement otpField = waitUtil.waitForElementToBeClickable(otpfield);

        otpField.sendKeys(otpValue);

        return otpValue;
    }
    public void ClickOnContinue() {
       WebElement continue1 = waitUtil.waitForElementToBeClickable(continueButton1);
        continue1.click();
    }
    
}
