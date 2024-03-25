package parallel;

import org.junit.Assert;

import com.Pages.MedicalDocumentPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MedicalDocumentSteps {

    private MedicalDocumentPage medicalDocumentPage = new MedicalDocumentPage(DriverFactory.getDriver());
    private String successMessage;

    @Given("the User is on the home page")
    public void the_user_is_on_the_home_page() {
        // Assume the user is on the home page or implement navigation if needed
        DriverFactory.getDriver().get("https://familycentral.com");
    }
    

  
    @When("the User clicks on Medical folder")
    public void the_user_clicks_on_medical_folder() {
    	System.out.println(">>>Feature: Medical Document Management Feature");
        medicalDocumentPage.clickOnMedicalFolder();
    }

    @When("the User clicks on Subscriber")
    public void the_user_clicks_on_subscriber() {
        medicalDocumentPage.clickOnSubscriber();
    }

    @When("the User clicks on Vaccine Cards folder")
    public void the_user_clicks_on_vaccine_cards_folder() {
        medicalDocumentPage.clickOnVaccineCardsFolder();
    }

    @When("the User clicks on Add option")
    public void the_user_clicks_on_add_option() {
        medicalDocumentPage.clickOnAddButton();
    }

   @When("the User clicks on New document to create a document")
    public void the_user_clicks_on_new_document_to_create_a_document() {
        medicalDocumentPage.clickOnNewDocument();
    }

    @When("the User enters {string} into Enter a document name")
    public void the_user_enters_into_enter_a_document_name(String documentName) {
        medicalDocumentPage.enterDocumentName(documentName);
    }

    @When("the User clicks on Next Button")
    public void the_user_clicks_on_next_button() {
        medicalDocumentPage.clickOnNextButton();
    }

    @When("the User clicks and Enter some text in the field")
    public void the_user_clicks_and_enter_some_text_in_the_field() {
    	medicalDocumentPage.enterTextInField();
    }

    @When("the User clicks on Save Button")
    public void the_user_clicks_on_button() {
    	medicalDocumentPage.clickOnSaveButton();
    	
    }

//    @Then("the User clicks on Close button")
//    public void the_user_clicks_on_button(String button) {
//    	medicalDocumentPage.clickOnCloseButton();
//    }
    
    @Then("the User should see a success message {string}")
    public void the_user_should_see_a_success_message(String successText) throws InterruptedException {
    	 successMessage = medicalDocumentPage.getSuccessMessage();
         Assert.assertTrue(successMessage.contains(successText));
    }  
    
    
//    Take Picture Code
    

    @When("User clicks on the Take a picture option")
    public void user_clicks_on_the_take_a_picture_option() throws InterruptedException {
    	Thread.sleep(3000);
    	medicalDocumentPage.clickOnTakePictureOption();
        
    }

    
    @Then("User accepts the allow pop up alert")
    public void user_accepts_the_allow_pop_up_alert() {
       medicalDocumentPage.handleCameraAlert();
        
    }
    
    
    @Then("User clicks on take a picture")
    public void user_clicks_on_take_a_picture() {
    	
    	medicalDocumentPage.selectTakePictureOption2();
    }

    @Then("User enters some text as File name")
    public void user_enters_some_text_as_file_name() {
    	medicalDocumentPage.enterFilename();
        
    }

    @Then("User cliks on the Save option")
    public void user_cliks_on_the_save_option() throws InterruptedException {
    	medicalDocumentPage.clickOnSaveButtonOfPicture();
    }
}
