package com.qa.factory2;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void setDriver(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver"); // Replace with your path
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with your path
            tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "path/to/edgedriver"); // Replace with your path
            tlDriver.set(new EdgeDriver());
        } else {
            System.out.println("Invalid browser name: " + browser);
        }

//        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

//    public static void closeDriver() {
//        getDriver().quit();
//    }
}




/*
 package com.qa.factory2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DriverFactory {

	WebDriver driver;
	
	FirefoxOptions firefoxOptions = new FirefoxOptions();
    ChromeOptions chromeOptions = new ChromeOptions();
	EdgeOptions edgeOptions = new EdgeOptions();
	
	
	@Parameters("browser")
	@BeforeTest
	public void initialize(String browser) {
		
		if (driver == null) {
		if(browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			System.out.println("Firefox is launched");
			
		}else if(browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			System.out.println("chrome is launched");
		}else if (browser.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			System.out.println("edge is launched");
		}
		
		}
		
	}
	
	
	
	@Test
	public void google_search() {
		
		 driver.get("https://www.google.com");
		 String pageTitle = driver.getTitle();
		 System.out.println(pageTitle);
	}
	
} */
