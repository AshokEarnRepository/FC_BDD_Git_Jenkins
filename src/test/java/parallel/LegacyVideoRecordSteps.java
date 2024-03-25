package parallel;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.Pages.LegacyMessageVideoRecord;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LegacyVideoRecordSteps {

	private LegacyMessageVideoRecord legacyMessagePage = new LegacyMessageVideoRecord(DriverFactory.getDriver());
	
	
	

    @Given("the user is on the Legacy Messages page")
    public void givenTheUserIsOnLegacyMessagesPage() {
    	System.out.println(">>>Feature: Legacy Video Record");
      
        legacyMessagePage.clickLegacyMessages();
    }

    @When("the user extracts OTP from smstome")
    public void whenTheUserExtractsOTPFromSmstome() throws InterruptedException {
        legacyMessagePage.extractOtpFromSmstome();
    }

    @When("the user clicks on Create your first message button")
    public void whenTheUserClicksOnCreateYourFirstMessageButton() {
        legacyMessagePage.clickCreateFirstMessage();
    }
    
    @And("the user click on the record One Here link")
    public void the_user_click_on_the_record_One_Here_link() {
        legacyMessagePage.clickRecordOneHere();
    }

    @When("the user clicks on Record video message button")
    public void whenTheUserClicksOnRecordVideoMessageButton() {
        legacyMessagePage.clickRecordVideoMessage();
    }

    @When("the user clicks on Record now button")
    public void whenTheUserClicksOnRecordNowButton() {
        legacyMessagePage.clickRecordNow();
    }

    @When("the user starts recording")
    public void whenTheUserStartsRecording() throws InterruptedException {
        legacyMessagePage.clickStartRecording();
    }

    @When("the user stops recording")
    public void whenTheUserStopsRecording() {
        legacyMessagePage.clickStopRecording();
    }

    @When("the user clicks on Next button")
    public void whenTheUserClicksOnNextButton() throws InterruptedException {
    	
        legacyMessagePage.clickNext();
    }

    @When("the user enters message title")
    public void whenTheUserEntersMessageTitle() throws InterruptedException {
        legacyMessagePage.enterRandomMessageTitle();
    }

    @When("the user clicks on Next button after entering message title")
    public void whenTheUserClicksOnNextButtonAfterEnteringMessageTitle() {
        legacyMessagePage.nextButtonMessageTitle();
    }

    @When("the user clicks on My Family")
    public void whenTheUserClicksOnMyFamily() {
        legacyMessagePage.clickMyFamily();
    }

    @When("the user selects all checkboxes")
    public void whenTheUserSelectsAllCheckboxes() {
        legacyMessagePage.SelectAll_CheckBox();
        
    }
    

    	@When("thes user clicks on Next button")
    	public void thes_user_clicks_on_next_button() {
    	legacyMessagePage.clickNextAfterSelectAll();
    	}
    	
    	@When("the user clicks on the Specific date label")
    	public void whenTheUserClicksOnSpecificDateLabel() {
    	    legacyMessagePage.clickSpecificDateLabel();
    	}



//        @When("the user selects specific date {string}, {string}, {string}")
//        public void whenTheUserSelectsSpecificDate(String year, String month, String day) {
//            legacyMessagePage.selectYear(year);
//            legacyMessagePage.selectMonth(month);
//            legacyMessagePage.selectDay(day);
//            
//        }
        
        @Then("User should see the Updated Successfully message")
        public void thenUserShouldSeeUpdatedSuccessfullyMessage() {
            assertTrue("Update success message is not displayed.", legacyMessagePage.isUpdateSuccessMessageDisplayed());
        }


    @When("the user clicks on the selected video")
    public void whenTheUserClicksOnSelectedVideo() throws InterruptedException {
        legacyMessagePage.clickSelectedVideo();
    }


    	
    
        @When("the user selects random year")
    	public void the_user_selects_random_year() {
    	
    	legacyMessagePage.selectRandomYear();
    	}

    	@When("the user selects random month")
    	public void the_user_selects_random_month() throws InterruptedException {
    		legacyMessagePage.selectRandomMonth();
    	}
    	@When("the user selects random day")
    	public void the_user_selects_random_day() {
    		legacyMessagePage.selectRandomYear();
    	}


    @When("the user clicks on Close button")
    public void whenTheUserClicksOnCloseButton() {
        legacyMessagePage.clickClose();
    }

    @Then("the user should see the Legacy Message title")
    public void thenTheUserShouldSeeTheLegacyMessageTitle() {
        String title = legacyMessagePage.getLegacyMessageTitle();
        // Add your assertion logic here
        // Example: Assert.assertEquals(expectedTitle, title);
    }

    // Add more step definitions as needed...

}
