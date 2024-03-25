package parallel;

import com.Pages.FileUpload_PhotosVideos;
import com.github.javafaker.Faker;
import com.qa.Utils.FolderNameGenerator;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

public class FileUpload_PhotosVideosSteps {

    private FileUpload_PhotosVideos fileUploadPhotosVideos = new FileUpload_PhotosVideos(DriverFactory.getDriver());
    
    
    
//    private String filePath = "C:\\Users\\Ashok\\Downloads\\Untitled.png";  // Provide the path of the file to be uploaded
    
//      private String filePath = "C:\\Users\\Ashok\\Downloads\\Passport5.jpg";
      private String filePath = "C:\\Users\\Ashok\\Downloads\\sample_960x540.mp4";
      

    @Given("User is on Home page")
    public void user_is_on_home_page() {
        // Assume the user is on the home page or implement navigation if needed
        // DriverFactory.getDriver().get("https://your-website-url.com");
    }

    @When("User clicks on Photos and Videos Section")
    public void user_clicks_on_photos_and_videos_section() {
    	System.out.println(">>>Feature: Upload a file functionality into Photos and Videos");
        fileUploadPhotosVideos.clickOnPhotosAndVideos();
    }
    
    @When("User clicks on Family Member")
    public void User_clicks_on_Family_Member() {
        fileUploadPhotosVideos.clickOnFamilyMember();
    }

    @When("User clicks on Add button")
    public void user_clicks_on_add_button() {
        fileUploadPhotosVideos.clickOnAddButton();
    }
    
    @When("User clicks on Upload Icon")
    public void User_clicks_on_Upload_Icon() {
    	
    	
        fileUploadPhotosVideos.clickOnUploadIcon();
    }

    @When("User uploads a file from the device")
    public void user_uploads_a_file_from_the_device() {
        fileUploadPhotosVideos.uploadFile(filePath);
//    	fileUploadPhotosVideos.uploadFile();
    }

    @Then("User should see the Uploaded Successfully Toast Message")
    public void user_should_see_the_uploaded_successfully_toast_message() throws InterruptedException {
        Assert.assertTrue(fileUploadPhotosVideos.isUploadedSuccessfullyVisible());
        
        Thread.sleep(5000);
    }
    
    // For Scenario 3 Steps 
    
    @When("User clicks on Subscriber Folder")
    public void user_clicks_on_subscriber_folder() {
    	fileUploadPhotosVideos.clickOnSubscriberFolder();
    }

    @When("User clicks on Add Option Button")
    public void user_clicks_on_add_option_button() {
    	fileUploadPhotosVideos.clickOnAddButton();
    }

//    @When("User clicks on New folder")
//    public void user_clicks_on_new_folder() {
//    	fileUploadPhotosVideos.clickOnNewFolderDropDown();
//    }
    
    @When("User clicks on New Folder from DropDown")
    public void User_clicks_on_New_Folder_from_DropDown() {
    	fileUploadPhotosVideos.clickOnNewFolderDropDown();
    }

    @When("User enters the Folder name")
    public void user_enters_the_folder_name() {
    	fileUploadPhotosVideos.enterFolderName();
    }

    @When("User clicks on the Submit button or Add")
    public void user_clicks_on_the_submit_button_or_add() {
    	fileUploadPhotosVideos.clickOnSubmitButton();
    }

    @Then("User should see the Successfully Added Message")
    public void user_should_see_the_successfully_added_message() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(fileUploadPhotosVideos.isPopUpSuccessWindowVisible());
    }

    @Then("User closes the Pop up Message")
    public void user_closes_the_pop_up_message() throws InterruptedException {
    	fileUploadPhotosVideos.closePopUpMessage();
    	Thread.sleep(2000);    }

    @Then("User should see the added Folder Name")
    public void user_should_see_the_added_folder_name() {
    	//Back and Forth
    	fileUploadPhotosVideos.clickOnPhotoVideosBack(); 
        System.out.println("Clickable Upload Icon and clicks back and forth");
    
//        Assert.assertTrue(fileUploadPhotosVideos.isAddedFolderVisible(folderName));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(fileUploadPhotosVideos.isAddedFolderVisible());
    }
    
    @When("User clicks the added folder")
    public void User_clicks_the_added_folder() {
    	fileUploadPhotosVideos.clickOnAddedFolder();
    }

    @When("User uploads a file into the folder")
    public void user_uploads_a_file_into_the_folder() {
    	
    	
    	fileUploadPhotosVideos.uploadFile(filePath);
        // Implement file upload logic here
    	
    	fileUploadPhotosVideos.isUploadedSuccessfullyVisible();
    }
    
    
    
    
    
    
}
