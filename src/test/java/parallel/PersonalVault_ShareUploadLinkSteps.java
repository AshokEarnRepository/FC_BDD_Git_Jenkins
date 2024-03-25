package parallel;

import java.util.ArrayList;

import com.Pages.PersonalVault_ShareUploadLink;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalVault_ShareUploadLinkSteps {

    private PersonalVault_ShareUploadLink personalVaultPage = new PersonalVault_ShareUploadLink(DriverFactory.getDriver());

    @Given("User clicks on personal vault")
    public void user_clicks_on_personal_vault() {
    	
        personalVaultPage.clickonPersonalvault();
        
    }

    @Given("User navigates to smstome website")
    public void user_navigates_to_smstome_website() throws InterruptedException {
        // Extract OTP from smstome and switch back to the original tab
        personalVaultPage.extractOtpFromSmstome();
        
    }

    @When("User shares an email")
    public void user_shares_an_email() {
    	System.out.println(">>>Feature: Personal Vault Share Upload");

    	personalVaultPage.firstname();
    	personalVaultPage.lastname();
    	personalVaultPage.email();
    	personalVaultPage.flag();    
    	personalVaultPage.searchcountry();
    	personalVaultPage.us();
    	personalVaultPage.phone();
    	personalVaultPage.validuntil();
    	personalVaultPage.validTill();
    	personalVaultPage.share();
    	
    }

    @Then("User goes to the appropriate email")
    public void user_goes_to_the_appropriate_email() {
       System.out.println("user navigated to the :");
    }

    @Then("User navigates to the yopmail and opens the website")
    public void user_navigates_to_the_yopmail_and_opens_the_website() {
        personalVaultPage.yopmail();
    }

    @Then("User opens the email and signs in")
    public void user_opens_the_email_and_signs_in() throws Throwable {
        personalVaultPage.enteremail();
        personalVaultPage.click();
        personalVaultPage.frame();
        personalVaultPage.emaillink();
        personalVaultPage.signin();
    }

    @Then("User enters the authentication code")
    public void user_enters_the_authentication_code() throws Throwable {
        personalVaultPage.code();
    }

    @Then("User uploads the file")
    public void user_uploads_the_file() {
        // Implement the step for uploading the file...
    }
}
