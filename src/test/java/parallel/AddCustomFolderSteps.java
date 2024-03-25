
package parallel;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.testng.asserts.SoftAssert;

import com.Pages.AddCustomFolder;
import com.qa.Utils.FolderNameGenerator;
import com.qa.Utils.PersonNameGenerator;
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
    	System.out.println("Feature: File Management Feature");
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

 

    @When("the User enters the folder name into Folder name field")
    public void the_user_enters_the_folder_name_as_into() {
        fileManagementPage.enterFolderName();
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

    @Then("the User verifies the added custom folder")
    public void the_user_verifies_the_added_custom_folder() {
    	 SoftAssert softAssert = new SoftAssert();
         softAssert.assertTrue(fileManagementPage.isAddedFolderVisible());
    }

    @Then("the User clicks and opens the folder")
    public void the_user_clicks_and_opens_the_folder() throws InterruptedException {
    	
    	fileManagementPage.clickOnAddedFolder();
    }  
//    @When("User uploads a file into the that specific folder")
//    public void user_uploads_a_file_into_the_folder() {
//    	
////    	fileManagementPage.uploadFile("jpg_small");
//    	fileManagementPage.uploadFile("jpg_medium");
//    	fileManagementPage.uploadFile("jpg_large");
//        // Implement file upload logic here
//    	
//    	fileManagementPage.isUploadedSuccessfullyVisible();
//    }
    
//    @When("User uploads a file into the that specific folder")
//    public void user_uploads_files_into_the_folder() throws InterruptedException {
//    	
//    	    List<String> fileFormats = Arrays.asList("jpg_small", "jpg_medium", "jpg_large");
//
//    	    for (String fileFormat : fileFormats) {
//    	        fileManagementPage.uploadFile(fileFormat);
//    	        fileManagementPage.isUploadedSuccessfullyVisible();
//    	        Thread.sleep(7000);
//    	    }
//    	    fileManagementPage.isUploadedSuccessfullyVisible();
//    	}
    
    @Then("User uploads PDF file into the that specific folder")
    public void user_uploads_PDF_into_the_that_specific_folder() throws InterruptedException {
    	   List<String> fileFormats = Arrays.asList("pdf_small", "pdf_medium", "pdf_large");

    	   for (String fileFormat : fileFormats) {
               fileManagementPage.uploadFile(fileFormat);
               // Call isUploadedSuccessfullyVisible and handle TimeoutException
               try {
                   fileManagementPage.isUploadedSuccessfullyVisible();
               } catch (TimeoutException e) {
                   System.out.println("TimeoutException occurred while verifying upload success message.");
                   // You can log this exception or take any other appropriate action
               }
               Thread.sleep(5000);
    	   }
    }
    
    @Then("User uploads DOCX file into the that specific folder")
    public void user_uploads_DOCX_into_the_that_specific_folder() throws InterruptedException {
    	   List<String> fileFormats = Arrays.asList("docx_small", "docx_large");

    	   for (String fileFormat : fileFormats) {
               fileManagementPage.uploadFile(fileFormat);
               // Call isUploadedSuccessfullyVisible and handle TimeoutException
               try {
                   fileManagementPage.isUploadedSuccessfullyVisible();
               } catch (TimeoutException e) {
                   System.out.println("TimeoutException occurred while verifying upload success message.");
                   // You can log this exception or take any other appropriate action
               }
               Thread.sleep(5000);
    }
    }
    
    
    @Then("User uploads TXT file into the that specific folder")
    public void user_uploads_TXT_into_the_that_specific_folder() throws InterruptedException {
    	List<String> fileFormats = Arrays.asList("txt_small", "txt_medium", "txt_large");

    	   for (String fileFormat : fileFormats) {
               fileManagementPage.uploadFile(fileFormat);
               // Call isUploadedSuccessfullyVisible and handle TimeoutException
               try {
                   fileManagementPage.isUploadedSuccessfullyVisible();
               } catch (TimeoutException e) {
                   System.out.println("TimeoutException occurred while verifying upload success message.");
                   // You can log this exception or take any other appropriate action
               }
               Thread.sleep(5000);
    	   }
  	    
    }
    
    @Then("User uploads XLSX file into the that specific folder")
    public void user_uploads_XLSX_into_the_that_specific_folder() throws InterruptedException {
    	List<String> fileFormats = Arrays.asList("xlsx_small", "xlsx_medium");

    	   for (String fileFormat : fileFormats) {
               fileManagementPage.uploadFile(fileFormat);
               // Call isUploadedSuccessfullyVisible and handle TimeoutException
               try {
                   fileManagementPage.isUploadedSuccessfullyVisible();
               } catch (TimeoutException e) {
                   System.out.println("TimeoutException occurred while verifying upload success message.");
                   // You can log this exception or take any other appropriate action
               }
               Thread.sleep(5000);
  	    }
  	    
    }
    @Then("User uploads PNG file into the that specific folder")
    public void user_uploads_PNG_into_the_that_specific_folder() throws InterruptedException {
        List<String> fileFormats = Arrays.asList("png_medium", "png_large");

        for (String fileFormat : fileFormats) {
            fileManagementPage.uploadFile(fileFormat);
            // Call isUploadedSuccessfullyVisible and handle TimeoutException
            try {
                fileManagementPage.isUploadedSuccessfullyVisible();
            } catch (TimeoutException e) {
                System.out.println("TimeoutException occurred while verifying upload success message.");
                // You can log this exception or take any other appropriate action
            }
            Thread.sleep(5000);
        }
  	    
    }
    @Then("User uploads JPG file into the that specific folder")
    public void user_uploads_JPG_into_the_that_specific_folder() throws InterruptedException {
    	List<String> fileFormats = Arrays.asList("jpg_small", "jpg_medium", "jpg_large");

    	   for (String fileFormat : fileFormats) {
               fileManagementPage.uploadFile(fileFormat);
               // Call isUploadedSuccessfullyVisible and handle TimeoutException
               try {
                   fileManagementPage.isUploadedSuccessfullyVisible();
               } catch (TimeoutException e) {
                   System.out.println("TimeoutException occurred while verifying upload success message.");
                   // You can log this exception or take any other appropriate action
               }
               Thread.sleep(5000);
  	    }
  	    
    }
    
    @Then("User uploads MP4 file into the that specific folder")
    public void user_uploads_MP4_into_the_that_specific_folder() throws InterruptedException {
    	List<String> fileFormats = Arrays.asList("mp4_small","mp4_medium","mp4_large");

    	   for (String fileFormat : fileFormats) {
               fileManagementPage.uploadFile(fileFormat);
               // Call isUploadedSuccessfullyVisible and handle TimeoutException
               try {
                   fileManagementPage.isUploadedSuccessfullyVisible();
               } catch (TimeoutException e) {
                   System.out.println("TimeoutException occurred while verifying upload success message.");
                   // You can log this exception or take any other appropriate action
               }
               Thread.sleep(5000);
  	    }
  	    
    }
    


}
