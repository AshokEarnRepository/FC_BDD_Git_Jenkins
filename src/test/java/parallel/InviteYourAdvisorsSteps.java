package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Pages.InviteYourAdvisors;
import com.qa.Utils.EmailGenerator;
import com.qa.Utils.PersonNameGenerator;
import com.qa.factory.DriverFactory;

public class InviteYourAdvisorsSteps {

    private InviteYourAdvisors invitePage = new InviteYourAdvisors(DriverFactory.getDriver());
    
    String invitePersonName = PersonNameGenerator.generateRandomPersonName();
	String invitePersonEmail = EmailGenerator.generateRandomEmail();
	
    
    @Given("I am on FamilyCentral Home Page")
    public void IamOnFamilyCentralHomePage() {
    	System.out.println("I am on Home page");
    }

    @When("I click on the Advisor Module")
    public void clickOnAdvisorModule() {
        invitePage.clickOnAdvisorModule();
    }

    @When("I click on the Invite Advisor button")
    public void clickInviteAdvisorButton() {
        invitePage.clickInviteAdvisorButton();
    }

    @When("I enter advisor details and send the invitation")
    public void enterAdvisorDetailsAndSendInvitation() {
    	
        invitePage.enterInvitePersonName(invitePersonName);
        invitePage.enterInvitePersonEmail(invitePersonEmail);
        invitePage.clickOnSendInvite();
        invitePage.verifyInviteSentMessage();
        invitePage.pendingIsDisplayed();
    }

    @When("I navigate to Yopmail to check the received email")
    public void navigateToYopmail() {
        invitePage.navigateToYopmail();
    }

    @When("I check the received invite email")
    public void checkAndAcceptInvite() throws InterruptedException {
        invitePage.checkReceivedInviteEmail(invitePersonEmail);
        invitePage.switchToEmailIframe();
        invitePage.clickOnSignUpNow();
    }
    
    @When("I accept the received invite")
    public void IAcceptedTheReceivedInvite() throws InterruptedException {
    	invitePage.acceptInvite();
    }
    
    @When("I Enter SighUp TPA Process")
    public void IEnterSighUpTPAProcess() throws InterruptedException {
        invitePage.enterAdvisorDetails();
        
    }

//    @When("I extract OTP from Smstome")
//    public void extractOtpFromSmstome() throws InterruptedException {
//        invitePage.extractOtpFromSmstome();
//    }

    @When("I enter OTP and continue")
    public void enterOtpAndContinue() throws InterruptedException {
    	
    	invitePage.extractOtpFromSmstome();
//        invitePage.ClickOnContinue();
    }

    @When("I enter new password and continue")
    public void enterNewPasswordAndContinue() {
    	
        invitePage.enterNewPasswordAndContinue();
    }

    @Then("I should see the invitation completed successfully")
    public void verifyInvitationCompletion() {
        // Add verification steps as needed
    	System.out.println(">>>I should see the invitation completed successfully");
    	
    }
    
}
