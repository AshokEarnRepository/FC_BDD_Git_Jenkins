package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SearchTestCase {
	
	WebDriver driver;
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");


	
	
	@BeforeTest
	public void browserLaunch() {
		
//		ExtentSparkReporter spark = new ExtentSparkReporter("spark.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		extent.attachReporter(spark);
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
		
	}
	
	@Test
	public void testCase1() {
		ExtentTest test = extent.createTest("Verify the page Title").assignAuthor("Ashok").assignCategory("FunctionalTestCases")
		.assignDevice("Windows");
		test.info("I am capturing page title");
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}
	

}
