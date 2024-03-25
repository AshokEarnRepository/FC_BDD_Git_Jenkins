package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class GoogleSearchSteps {

    private WebDriver driver;

    @Given("I open Google Chrome browser")
    public void iOpenGoogleChromeBrowser() {
//        driver = new ChromeDriver();
    	System.out.println("print");
    }

    @When("I navigate to the Google homepage")
    public void iNavigateToTheGoogleHomepage() {
        driver.get("https://www.google.com");
    }

    @Then("I get the title of the page")
    public void iGetTheTitleOfThePage() {
        String pageTitle = driver.getTitle();
        assertEquals("Google", pageTitle);
        driver.quit();
    }
}
