package testRunners;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlSuite;

import com.qa.Utils.ConfigReader;
import com.qa.factory.DriverFactory;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = {"src/test/resources/features/Calendar_NewEvent.feature"},
//	    features = {"src/test/resources/features/"},
	    glue = {"parallel", "AppHooks"},
		
		// Below two lines is for Parallel execution
//		features = {"src/test/resources/parallel/"},
//	    glue = {"parallel"},
	    
//	    tags = "@login", // Include scenarios with any of these tags,
//	    dryRun=true,
	    publish = true,
	    plugin   = {"pretty", "html:target/CucumberReport.html",
	    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//	    		"return:target/failedrerun.txt"
	    		
	    		}
	)
public class ParallelRunTest extends AbstractTestNGCucumberTests {

	private static WebDriver driver;

//	If you want to run from TestRunner only then uncomment this below code
	
//    @BeforeClass
//    public static void setUp() {
//        driver = DriverFactory.getDriver();
//    }
	
//	If you want to run from TestRunner only then uncomment this above code
    
    
	//crossBrowser SetUp>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")  // No quotes around "browser"
	public void setUp(@Optional String browser) {  // No need for @Parameters here
	    driver = DriverFactory.init_driver(browser);
	}
	
	//crossBrowser SetUp>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
    // Override scenarios method to use the shared WebDriver instance
    @Override
    @DataProvider(parallel=false)
    public Object[][] scenarios(){
    	
        return super.scenarios();
    }

    // Override after method to quit the WebDriver after scenario execution
    @AfterClass
    public static void tearDown() {
        if (driver != null) {
        	
        	System.out.println("Browser Closed if I put driver.quit here");
//            driver.quit();
        }
    }
    
    
}
	
	
	
	
	
	
	
	
	
	
	
	
//	or>>>>>>>>>>>>>>>>>
	/*
	   private static WebDriver driver;

	    @BeforeClass
	    public void setUp(XmlSuite suite) {
	        ConfigReader configReader = new ConfigReader();
	        configReader.init_prop(suite);
	        String browser = configReader.getProperty("browser");
	        driver = DriverFactory.init_driver(browser);
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit(); // Quit the WebDriver after all scenarios
	        }
	}

} */

	/*
	 
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios(){
		
		return super.scenarios();
	}

}

*/