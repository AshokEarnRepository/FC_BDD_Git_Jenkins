
package parallel;

import org.junit.Assert;

import com.Pages.AddCustomFolder;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCustomFolderSteps {

    private AddCustomFolder fileManagementPage = new AddCustomFolder(DriverFactory.getDriver());
    
    
    private String successMessage;
    private String addedFolderName;

//      @Given("the User is on the home page")
//    public void the_user_is_on_the_home_page() {
//        // Assume the user is on the home page or implement navigation if needed
//    	DriverFactory.getDriver().get("https://familycentral.com");
//    } 

    @When("the User clicks on Family Access Files")
    public void the_user_clicks_on_family_access_files() {
    	fileManagementPage.clickOnFamilyAccessFiles();
    }

    @When("the User clicks on Add Folder")
    public void the_user_clicks_on_add_folder() {
      
    	fileManagementPage.clickOnAddFolder();
    }

 

    @Then("the User clicks on close user guide")
    public void the_user_clicks_on_close_user_guide() {
       
    	fileManagementPage.clickOnCloseUserGuide();
    }

 

    @When("the User enters the folder name as {string} into Folder name field")
    public void the_user_enters_the_folder_name_as_into(String folderName) {
        fileManagementPage.enterFolderName(folderName);
    }

    @When("the User clicks on the Add button")
    public void the_user_clicks_on_the_button() {
       
            fileManagementPage.clickOnAddButton();
       
    }

    @Then("the User should see a success popup with the message {string}")
    public void the_user_should_see_a_success_popup_with_the_message(String expectedMessage) {
        successMessage = fileManagementPage.getSuccessPopupMessage();
        Assert.assertTrue(successMessage.contains(expectedMessage));
    }

//    @Then("the User verifies the added custom folder {string}")
//    public void the_user_verifies_the_added_custom_folder(String expectedFolderName) {
//        addedFolderName = fileManagementPage.getAddedCustomFolderText();
//        Assert.assertEquals(expectedFolderName, addedFolderName);
//    }
//
//    @Then("the User clicks and opens the folder {string}")
//    public void the_user_clicks_and_opens_the_folder(String folderName) {
//        fileManagementPage.clickAndOpenFolder();
//        // Implement further actions if needed
//    }  
    
    
    
}
