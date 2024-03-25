
///*

package AppHooks;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.xml.XmlSuite;

import com.qa.Utils.ConfigReader;
import com.qa.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    
    @Before(order=0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }
    
    @Before(order=1)
    public void LaunchBrowser() {
        String browsername = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = DriverFactory.init_driver(browsername);
    }
    
    @After(order=1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take Screenshot
            String screenshotName = scenario.getName().replaceAll("", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
        // Reset browser state for the next scenario
        // This can involve clearing cookies, refreshing the page, or navigating to a certain URL
        // For example:
        // driver.manage().deleteAllCookies();
        // driver.navigate().refresh();
    }
}



//*/

//Or>>>>>>>>>>>>>>>>>>>>>>>>>>>>


