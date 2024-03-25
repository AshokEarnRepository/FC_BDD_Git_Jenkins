package AppHooksMyTestRunner;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlSuite;

import com.qa.Utils.ConfigReader;
import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks_MyTestRunner {

    private static WebDriver driver;

    @Before(order = 0)
    public void getProperty() {
        ConfigReader configReader = new ConfigReader();
        Properties prop = configReader.init_prop();
    }

    @Before(order = 1)
    @Parameters("browser")
    public void launchBrowser(String browser) {
        driver = DriverFactory.init_driver(browser);
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
        driver.quit();
    }
}
