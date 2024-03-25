package parallel;

import static org.junit.Assert.assertTrue;

import com.Pages.Calendar_NewEvent;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Calendar_NewEventSteps {
    private Calendar_NewEvent newEventPage = new Calendar_NewEvent(DriverFactory.getDriver());

    @Given("the user is on the Calendar page")
    public void the_user_is_on_the_calendar_page() {
    	System.out.println("Feature: Calendar Event Creation with Recurring and Reminder Options");
        newEventPage.clickOnCalendar();
    }

    @When("the user clicks on New Event")
    public void the_user_clicks_on_new_event() {
        newEventPage.clickOnNewEvent();
    }

    @When("User enters {string} into EventTitle")
    public void user_enters_into_event_title(String EventName) {
        newEventPage.enterEventTitle(EventName);
    }

    @When("selects the start date on the calendar")
    public void selects_the_start_date_on_the_calendar() {
        newEventPage.selectStartDate();
    }
    
    @When("selects the End date on the calendar")
    public void selects_the_end_date_on_the_calendar() {
    	newEventPage.selectEndDate();
    }


    @When("User sets the start time to {string}")
    public void user_sets_the_start_time_to(String startTime) {
        newEventPage.clickOnStartTimeInput();
    }

    @When("User sets the end time to {string}")
    public void user_sets_the_end_time_to(String endTime) {
        newEventPage.clickOnEndTimeDropDown();
    }

    @When("chooses to set a recurring event")
    public void chooses_to_set_a_recurring_event() {
        newEventPage.clickOn_RECURRING_EVENT_DROPDOWN();
    }

    @When("User sets the recurrence to Monthly")
    public void user_sets_the_recurrence_to() {
        System.out.println("This option selected in the :RecurringEvnetDropDown");
    }

    @When("User selects the specific day {string}")
    public void user_selects_the_specific_day(String day) {
        // Implement logic to select the day
    }

    @When("User chooses the year {string}")
    public void user_chooses_the_year(String year) {
        // Implement logic to choose the year
    }

    @When("User sets a reminder for {string}")
    public void user_sets_a_reminder_for(String reminder) {
        newEventPage.selectReminder();
    }

    @When("assigns the event to family member")
    public void assigns_the_event_to_family_member() {
        newEventPage.addPeople();
    }

    @When("enters someText into the description")
    public void enters_some_text_into_the_description() {
        newEventPage.enterDescription();
    }

    @When("clicks on save")
    public void clicks_on_save() {
        newEventPage.clickOnSave();
    }

    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedMessage) {
        assertTrue(newEventPage.isEventCreatedSuccessfully());
    }

//    @Then("the calendar should display the newly created monthly recurring event")
//    public void the_calendar_should_display_the_newly_created_monthly_recurring_event() {
//        assertTrue(newEventPage.isNewEventDisplayed());
//    }
}
