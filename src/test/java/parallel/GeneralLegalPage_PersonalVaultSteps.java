package parallel;


import com.Pages.GeneralLegalPage_PersonalVault;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

 
public class GeneralLegalPage_PersonalVaultSteps {
 
    private final GeneralLegalPage_PersonalVault generalLegalPages = new GeneralLegalPage_PersonalVault(DriverFactory.getDriver());
   private String filePath;
 
   @When("user clicks on general legal information")
   public void user_clicks_on_general_legal_information() {
	   System.out.println(">>> Feature: PersonalVault General Legal Information of Uploading Different file types");
        generalLegalPages.clickgenerallegal();
   }
 
   @And("user clicks on add option")
   public void user_clicks_on_add_option() {
        generalLegalPages.addfile();
    }
 
    @And("user clicks on upload file")
    public void user_clicks_on_upload_file() throws InterruptedException {
        filePath = getFilepathForFileNumber(1);
        System.out.println(">>upload file 1: " +filePath);
        generalLegalPages.uploadfile(filePath);
   }
 
  @When("user clicks on upload file{int}")
   public void user_clicks_on_upload_file(int fileNumber) throws InterruptedException {
        filePath = getFilepathForFileNumber(fileNumber);
       System.out.println(">>upload file : " +filePath);
        generalLegalPages.uploadfile(filePath);
   }
    
 
 
   @Then("User should see the {string} Message")
   public void user_should_see_the_message(String filename) throws InterruptedException {
        generalLegalPages.verify();
   }
 
    private String getFilepathForFileNumber(int fileNumber) {
       // Implement your logic to return the file path based on the fileNumber
       // Example: You can use a switch statement or any other logic
       switch (fileNumber) {
           case 1:
               return "C:\\Users\\Ashok\\Downloads\\Untitled.png";
          case 2:
               return "C:\\Users\\Ashok\\Documents\\Medium_sample-pdf-download-10-mb.pdf";
            case 3:
               return "Security-at-Family-Central-v2 (1).pdf";
           case 4:
              return "C:\\Users\\Ashok\\Downloads\\TestCase_Scenario.xlsx";
            case 5:
               return "C:\\Users\\Ashok\\Downloads\\Small-Sample-png-Image-File-Download.jpg";
            case 6:
               return "C:\\Users\\Ashok\\Downloads\\LocalFolder.txt";
          // Add more cases as needed
           default:
                return ""; // Return a default value or handle the case appropriately
       }    }
}