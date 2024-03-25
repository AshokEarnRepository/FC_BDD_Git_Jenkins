/*
 * package testRunners;
 * 
 * import org.testng.annotations.AfterClass; import
 * org.testng.annotations.BeforeClass; import
 * org.testng.annotations.DataProvider; import org.testng.xml.XmlSuite;
 * 
 * import com.qa.factory.DriverFactory;
 * 
 * import io.cucumber.testng.AbstractTestNGCucumberTests; import
 * io.cucumber.testng.CucumberOptions;
 * 
 * @CucumberOptions( features =
 * {"src/test/resources/features/PersonalVault_GeneralLegal.feature"}, glue =
 * {"parallel", "AppHooksMyTestRunner"}, tags = "@tag0", publish = true, plugin
 * = {"pretty", "html:target/CucumberReport.html",
 * "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} )
 * public class MyTestRunner extends AbstractTestNGCucumberTests {
 * 
 * @Override
 * 
 * @DataProvider(parallel = true) public Object[][] scenarios() { return
 * super.scenarios(); } }
 * 
 * 
 * //or>>>>
 * 
 * 
 * package testRunners;
 * 
 * import org.testng.annotations.AfterClass; import
 * org.testng.annotations.BeforeClass; import
 * org.testng.annotations.DataProvider; import
 * org.testng.annotations.Parameters; import org.testng.annotations.Test;
 * 
 * import com.qa.factory2.DriverFactory;
 * 
 * import io.cucumber.testng.AbstractTestNGCucumberTests; import
 * io.cucumber.testng.CucumberOptions; import stepDefinitions.GooglePageSteps;
 * 
 * @CucumberOptions( features = {"src/test/resources/features"}, // Update path
 * to your feature file directory glue = {"com.qa.steps"}, plugin = {"pretty",
 * "html:target/cucumber-reports"}, tags = "@google" // Add a tag for clarity
 * (optional) ) public class MyTestRunner extends AbstractTestNGCucumberTests {
 * 
 * private GooglePageSteps googlePageSteps;
 * 
 * @BeforeClass(alwaysRun = true)
 * 
 * @Parameters("browser") public void setUp(String browser) {
 * DriverFactory.setDriver(browser); googlePageSteps = new GooglePageSteps(); }
 * 
 * @Test(dataProvider = "scenarios") // Assuming you have a data provider named
 * "scenarios" public void runCucumberTest(int scenario) { super.scenarios(); }
 * 
 * // @AfterClass(alwaysRun = true) // public void tearDown() { //
 * DriverFactory.closeDriver(); // }
 * 
 * @Override
 * 
 * @DataProvider(parallel = true) public Object[][] scenarios() { return
 * super.scenarios(); } }
 * 
 */