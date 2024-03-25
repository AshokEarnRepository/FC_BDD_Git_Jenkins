package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStepDifinition {
	

	@Given("User is on Sign Up Page")
	public void user_is_on_sign_up_page() {
		
	   System.out.println("User Signed up");
	}

	@When("User is click on Sign Up Option")
	public void user_is_click_on_sign_up_option() {
		
		System.out.println("User ");
	}

	@Then("User should navigates to Sign Up page")
	public void user_should_navigates_to_sign_up_page() {
	  
		System.out.println("User Sign");
	}
	
}
