package parallel;


import com.Pages.ShareFeedback;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShareFeedbackSteps {

    private final ShareFeedback shareFeedback;

    public ShareFeedbackSteps() {
        this.shareFeedback = new ShareFeedback(DriverFactory.getDriver()); // Assuming you have a DriverFactory class
    }

    @When("user clicks on Share Feedback")
    public void user_clicks_on_share_feedback() {
        shareFeedback.clickOn_ShareFeedBack();
    }

    @Then("user should see the Tell us how we can improve Family Central text")
    public void user_should_see_the_tell_us_how_we_can_improve_family_central_text() {
        assert shareFeedback.verify_TellUsText();
    }

    @Then("user should verify email is present in Share Feedback section")
    public void user_should_verify_email_is_present_in_share_feedback_section() {
        shareFeedback.verify_Email();
    }

    @Then("user should verify phone number is present in Share Feedback section")
    public void user_should_verify_phone_number_is_present_in_share_feedback_section() {
        shareFeedback.verify_PhoneNumber();
    }

    @When("user enters description")
    public void user_enters_description() {
        shareFeedback.enterDescription();
    }

    @When("user clicks on Send button")
    public void user_clicks_on_send_button() {
        shareFeedback.clickOn_SendButton();
    }
    @When("user verifies PopUpText and SuccessMessage")
    public void user_verifies_PopUpText_and_SuccessMessage() {
        shareFeedback.verify_SuccesMessage_And_PopUpMsg();
    }
}

