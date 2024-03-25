package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.Pages.FileUpload_PhotosVideos;
import com.Pages.MedicalDocumentPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;

public class CommonMethods {
	
	WebDriver driver;
	
	 private FileUpload_PhotosVideos fileUploadPhotosVideos = new FileUpload_PhotosVideos(DriverFactory.getDriver());
//	 private MedicalDocumentPage PrepMedical = new MedicalDocumentPage(DriverFactory.getDriver());
	 
	 public CommonMethods(WebDriver driver) {
		 this.driver = driver;
	 }
	
	
	  @Then("User go back and click Home")
	    public void UserGobackandClickHome() {
	    	//Back and Forth
	    	fileUploadPhotosVideos.clickOnPhotosAndVideos();
	    	fileUploadPhotosVideos.clickOnSubscriberFolder();
	        System.out.println("Clickable Upload Icon and clicks back and forth");

	    }
	
//	  @Then("User clicks on EmergencyPrep")
//	    public void UserclicksonEmergencyPrep() {
//	    	//Back and Forth
//		  PrepMedical.clicksonEmergencyPrep();
//
//	    }

}
