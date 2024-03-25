package parallel;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Pages.MyFamily;
import com.github.javafaker.Faker;
import com.qa.Utils.EmailGenerator;
import com.qa.Utils.PersonNameGenerator;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyFamilySteps {


	String invitePersonEmail;

	WebDriver driver;

    private MyFamily myFamilyPage = new MyFamily(DriverFactory.getDriver());
    String InvitepersonEmail = "FamilyMemberOne@yopmail.com";
    
    
    public static String generateRandomPersonName() {
        Faker faker = new Faker();
        return faker.name().fullName();
    }
    
//   --------------Dummy------------------
//   
//   private MyFamilySteps(WebDriver driver) {
//	 this.driver=driver;
//   }
//    
//    @Given("User is on Join family page")
//    public void user_is_on_join_family_page() {
//        driver.findElement(By.xpath("//button[text()='View Family Members']")).click();
//        
//    }
//    @When("User go through all clicks")
//    public void user_go_through_all_clicks() {
//    	
//      
//    }
//    
//    --------------Dummy------------------ 
//    

    @Given("User is on My Family Module")
    public void user_is_on_my_family_module() {
        // Navigate to My Family Module
        myFamilyPage.navigateToMyFamilyModule();
    }

    @When("User clicks on AddMember")
    public void user_clicks_on_add_member() {
        // Click on AddMember
        myFamilyPage.clickOnAddMember();
    }

    @Then("User should see the PopUpWindow")
    public void user_should_see_the_popup_window() {
        // Verify PopUpWindow
        myFamilyPage.verifyPopUpWindow();
    }
    
   

    @And("User Enters the Invite Person Name")
    public void user_enters_invite_person_name() {
        // Enter Invite Person Name
        String invitePersonName = PersonNameGenerator.generateRandomPersonName();
        myFamilyPage.enterInvitePersonName(invitePersonName);
    }
   
    
    @And("User Enters Invite Email Address")
    public void user_enters_invite_email_address() {
        // Enter Invite Email Address
         invitePersonEmail = EmailGenerator.generateRandomEmail();
        myFamilyPage.enterInvitePersonEmail(invitePersonEmail);
    }


    @And("User Clicks on Send Invite")
    public void user_clicks_on_send_invite() {
        // Click on Send Invite
        myFamilyPage.clickOnSendInvite();
        
    }

    @Then("User Should see the \"Invite has been sent to email\" Message")
    public void user_should_see_invite_sent_message() {
        myFamilyPage.verifyInviteSentMessage();
       
    }
    
    @Then("User Should see the \"Invite has been sent to email\" Message2")
    public void user_should_see_invite_sent_message2() {
        myFamilyPage.verifyInviteSentMessageTWO();
       
    }

    @When("User Navigates to Yopmail")
    public void user_navigates_to_yopmail() {
        // Navigate to Yopmail
        myFamilyPage.navigateToYopmail();
    }

    // Continue with the remaining steps...

    // Similar steps for the Smoke Test scenario...
 // ... (Previous steps)

    @And("Check for Received Invite Email")
    public void check_for_received_invite_email() {
        // Check for Received Invite Email
        myFamilyPage.checkReceivedInviteEmail(invitePersonEmail);
    }

    @And("User Switch to Email Iframe")
    public void switch_to_email_iframe() {
        // Switch to Email Iframe
        myFamilyPage.switchToEmailIframe();
    }

    @And("User Click on Create Account")
    public void click_on_create_account() {
        // Click on Create Account
        myFamilyPage.clickOnCreateAccount();
    }

    @And("User Join Your Family")
    public void join_your_family() throws InterruptedException {
        // Join Your Family
        myFamilyPage.joinYourFamily();
    }

    @And("User Continue on NextPage1")
    public void continue_on_yopmai2() throws InterruptedException {
        // Continue on Yopmail
        myFamilyPage.continueOnYopmail();
    }

    @And("User Enter Password and Confirm Password")
    public void enter_password_and_confirm_password() {
        // Enter Password and Confirm Password
        myFamilyPage.enterPasswordAndConfirm(InvitepersonEmail);
    }

    @And("User Continue on NextPage2")
    public void continue_on_yopmail() throws InterruptedException {
        // Continue on Yopmai
        myFamilyPage.continueOnYopmail();
    }

    @And("User Select Country, Enter Phone Number, and Send Code")
    public void select_country_enter_phone_number_and_send_code() {
        // Select Country, Enter Phone Number, and Send Code
        myFamilyPage.selectCountryEnterPhoneAndSendCode(null);
    }

    @And("User Verify OTP Element Presence")
    public void verify_otp_element_presence() {
        // Verify OTP Element Presence
        myFamilyPage.verifyOtpElementPresence();
    }

    @And("User Enter OTP")
    public void enter_otp() {
        // Enter OTP
        myFamilyPage.enterOtp(InvitepersonEmail);
    }

    @And("User Complete Registration")
    public void complete_registration() throws InterruptedException {
        // Complete Registration
        myFamilyPage.completeRegistration(InvitepersonEmail, InvitepersonEmail);
    }

    @And("User Verify Home")
    public void verify_home() {
        // Verify Home
        myFamilyPage.verifyHome();
    }

    // ... (Any additional steps if needed)


}

