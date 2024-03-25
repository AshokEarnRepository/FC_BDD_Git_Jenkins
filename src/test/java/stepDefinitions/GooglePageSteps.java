package stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory2.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GooglePageSteps {

    private WebDriver driver;

    public GooglePageSteps() {
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @Given("I am on the Google Search page")
    public void navigateToGoogle() {
        driver.get("https://www.google.com");
    }

    @Then("the page title should be \"Google\"")
    public void verifyGoogleTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page title is correct: " + actualTitle);
        } else {
            System.out.println("Page title is incorrect! Expected: " + expectedTitle + ", Actual: " + actualTitle);
        }
    }
}
