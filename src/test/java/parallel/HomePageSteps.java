package parallel;


import com.Pages.HomePage;
import com.Pages.InviteYourAdvisors;
import com.github.javafaker.Faker;
import com.qa.Utils.PersonNameGenerator;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	
	private HomePage homepage = new HomePage(DriverFactory.getDriver());
	
//    public static String generateRandomPersonName() {
//        Faker faker = new Faker();
//        return faker.name().fullName();
//    }

    @Given("user is on home page")
    public void user_is_on_home_page() throws InterruptedException {
    	homepage.VerifyHomePage();
    	
    }

    @When("Verify the Are you ready to start your day?")
    public void VerifyAreyoureadytostartyourday() throws InterruptedException {
    	
    	homepage.VerifyHomePage();
    	homepage.VerifyGetStartedText();
    	
    }


    @Then("User should see the")
    public void user_should_see_the() {
        // Implement verification steps for what the user should see
    }

//    @When("Verify the Lets get started Section is visible")
//    public void verify_the_lets_get_started_section_is_visible() {
//
//    	homepage.VerifyGetStartedText();
//    }


    @When("User clicks on Invite your Advisors")
    public void user_clicks_on_invite_your_advisors() {
        // Implement clicking on "Invite your Advisors"
    }

    @And("User clicks on the Invite option to invite a TPA")
    public void user_clicks_on_invite_option_to_invite_TPA() {
        // Implement clicking on the Invite option to invite a TPA
    }

    @Then("User Clicks on home page")
    public void user_clicks_on_home_page() {

    	homepage.clickOnHome();
    }
    
    @Then("User clicks on Your family tab")
    public void UserClicksOnYourfamilytab() {

    	homepage.ClickYourFamilyTab();
    	}
    
    @And("User clicks on Trusted Professional Advisor tab")
    public void user_clicks_on_trusted_professional_advisor_tab() {
        // Implement clicking on Trusted Professional Advisor tab
    }

    @And("User verifies the TPA Names from the list")
    public void user_verifies_TPA_names_from_the_list() {
        // Implement verification of TPA Names from the list
    }

    @Then("User should see the TPA added name under Trusted professional section")
    public void user_should_see_TPA_added_name_under_trusted_professional_section() {
        // Implement verification of TPA added name under Trusted professional section
    }

    @And("Verify the exact match with the added TPA")
    public void verify_exact_match_with_added_TPA() {
        // Implement verification of the exact match with the added TPA
    }
    
    @Then("User should see the Added FamilyMember")
    public void user_should_see_the_added_family_member() {
    	String invitePersonName = PersonNameGenerator.generateRandomPersonName();
        homepage.AllYourfamilyList(invitePersonName);
    }
}
