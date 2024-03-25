package parallel;

import com.Pages.accountmenupage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class AccountmenuSteps {
	private accountmenupage accountmenupage = new accountmenupage(DriverFactory.getDriver());
 
	
	@When("user clicks on the account memu")
	public void user_clicks_on_the_account_memu() {
		accountmenupage.accountmenu();
	}


	@Then("user clicks on the my accounts")
	public void user_clicks_on_the_my_accounts() {
		accountmenupage.myaccount();
	}

	@Then("user clicks on the edit option")
	public void user_clicks_on_the_edit_option() {
		accountmenupage.edit();
	}


	@Then("user modify the data and clicks on save option")
	public void user_modify_the_data_and_clicks_on_save_option() throws InterruptedException {
		accountmenupage.fields();
		accountmenupage.savechange();
	}

	@Then("user clicks on Password")
	public void user_clicks_on_password() {
		accountmenupage.password();
	}


	@Then("user enters the current password")
	public void user_enters_the_current_password() {
		accountmenupage.current("Password@123");
	}


	@Then("user enters the new password and confirm password")
	public void user_enters_the_new_password_and_confirm_password() {
		accountmenupage.newpass("Password@1234");
		accountmenupage.confirm("Password@1234");
	}


	@Then("user clicks on savechanges")
	public void user_clicks_on_savechanges() throws InterruptedException {
		accountmenupage.save();
		
		accountmenupage.password();
		Thread.sleep(2000);
		accountmenupage.current("Password@1234");
		accountmenupage.newpass("Password@123");
		accountmenupage.confirm("Password@123");
		accountmenupage.save();
	}

	@Then("user clicks on executor")
	public void user_clicks_on_executor() {
		accountmenupage.Executor();
	}


	@Then("user enters the first name and lastname")
	public void user_enters_the_first_name_and_lastname() {
		accountmenupage.fname();
		accountmenupage.lname();
	}

	@Then("user enters the email and phone number")
	public void user_enters_the_email_and_phone_number() {
		accountmenupage.email();
		accountmenupage.executornumber();
	}

	@Then("user sends the invitation to the executor")
	public void user_sends_the_invitation_to_the_executor() throws InterruptedException {
		accountmenupage.send();
		Thread.sleep(2000);
	}


	@When("user clicks on emergency contact")
	public void user_clicks_on_emergency_contact() {
		accountmenupage.Emergencycontact();
	}
	@Then("user enters firstname and last name")
	public void user_enters_firstname_and_last_name() {
		accountmenupage.efname();
		accountmenupage.elname();
	}
	@Then("user enters the email and emergency phone number")
	public void user_enters_the_email_and_emergency_phone_number() {
		accountmenupage.eemail();
		accountmenupage.ephone();
	}
	@Then("user clicks on send")
	public void user_clicks_on_send() throws InterruptedException {
		accountmenupage.savedone();
	}
 
 
 
 
}