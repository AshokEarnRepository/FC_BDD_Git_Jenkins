package parallel;

import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	
	private static String title;
	
	//Creating an object for the Constructor created in the LoginPage Class.
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());  //? How this is taking Driver here
	// and this getDriver() method will be giving you the in run time whatever the driver is going on it will give that driver
	// When loginpage.java will be executed but before that Hooks will be executed
	
		
		@Given("user is on landing page")
		public void user_is_on_landing_page() {
			System.out.println(">>>Feature: login page feature");
			  DriverFactory.getDriver().get("https://www.familycentral.com/");
//				loginpage.();
				loginpage.getLoginPageTitle();
			
		}
	 
		@When("user gets the title of the page")
		public void user_gets_the_title_of_the_page() {
			 String title = loginpage.getLoginPageTitle();
			  System.out.println("login page title is: "+title);
			
			
		}
	 
	 
	 
		
		@When("user clicks on LandingPageLogin")
		public void user_clicks_on_landing_page_login() {
			loginpage.landPageLoginOption();
		}
		@When("user clicks on login option of families")
		public void user_clicks_on_login_option_of_families() {
			loginpage.FamilyLoginOption();
		}
		
		@Then("user should navigate to login page")
		public void user_should_navigate_to_login_page() {
		   
		System.out.println("user navigate to login page");
			
		}
		
		
//		 When user clicks on LandingPageLogin
//		    And user clicks on login option of families
	 
		@When("user enters username as {string} into email field")
		public void user_enters_username_as_into_email_field(String username) throws InterruptedException {
		   
			loginpage.enteremailaddress(username);
			
		}
	 
		@When("user enters password as {string} into password field")
		public void user_enters_password_as_into_password_field(String password) {
		   
			loginpage.enterpassword(password);
			
		}
	 
		@When("user clicks on login button")
		public void user_clicks_on_login_button() {
		  
			loginpage.clickOnLogin();
			
		}
	 
		@Then("user gets the family central page")
		public void user_gets_the_family_central_page() {
			  System.out.println("Entered into Dashboad: ");
			
			
		}
		@Then("page title should be {string}")
		public void page_title_should_be(String expectedPageTitle) {
			
			System.out.println("extracted Page Title is :"+title);
			System.out.println("feature Page Title is :"+expectedPageTitle);
			
//			Assert.assertEquals(title, expectedPageTitle);
	 
		
		}
	 
	 
	}